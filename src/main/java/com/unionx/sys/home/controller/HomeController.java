package com.unionx.sys.home.controller;

import com.unionx.core.aop.login.LoginLogAop;
import com.unionx.core.enums.SexEnum;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.web.BizException;
import com.unionx.sys.module.vo.Module;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * 系统主页以及登录退出功能
 *
 * @author song junjie
 */
@Slf4j
@Controller
public class HomeController {

    /**
     * 系统首页
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        try {
            request.setAttribute("sexList", SexEnum.getList());
            UserDetails userDetails = (UserDetails) SecurityUtils.getSubject().getPrincipal();
            List<Module> moduleList = userDetails.getModuleList();
            if(!CollectionUtils.isEmpty(moduleList)){
                request.setAttribute("moduleList", getModuleTreeNote(moduleList));
            }else{
                request.setAttribute("moduleList","");
            }
        }catch (Exception e){
            log.error("",e);
        }
        return "index";
    }

    /**
     * 组装导航栏数据
     * @param allModule
     * @return
     * @author abner
     */
    public List<Module> getModuleTreeNote(List<Module> allModule){
        List<Module> moduleTree = new ArrayList<>();
        for (Module module : allModule) {
            boolean isFindParent = false;
            for (Module moduleTemp : allModule) {
                if (module.getParentCode() != null && module.getParentCode().equals(moduleTemp.getCode())) {
                    isFindParent = true;
                    if (moduleTemp.getChildren() == null) {
                        moduleTemp.setChildren(new ArrayList<Module>());
                    }
                    moduleTemp.getChildren().add(module);
                    break;
                }
            }
            if (!isFindParent) {
                moduleTree.add(module);
            }
        }
        return moduleTree;
    }

    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    /**
     * 执行登陆操作
     *
     * @param username
     * @param password
     * @param rememberMe
     * @return
     */
    @LoginLogAop
    @RequestMapping(value = "/login")
    @ResponseBody
    public CommonResponse login(HttpServletRequest request,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam(value = "rememberMe", required = false) String rememberMe) {

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return new CommonResponse(false, CommonResponse.LOGIN_FAILED);
        }
        UsernamePasswordToken token = null;
        String host = request.getHeader("x-forwarded-for");
        if (host == null || host.length() == 0 || "unknown".equalsIgnoreCase(host)) {
            host = request.getHeader("Proxy-Client-IP");
        }
        if (host == null || host.length() == 0 || "unknown".equalsIgnoreCase(host)) {
            host = request.getHeader("WL-Proxy-Client-IP");
        }
        if (host == null || host.length() == 0 || "unknown".equalsIgnoreCase(host)) {
            host = request.getRemoteAddr();
        }
        if (rememberMe != null && rememberMe.equals("true")) {
            token = new UsernamePasswordToken(username, password, true, host);
        } else {
            token = new UsernamePasswordToken(username, password, false, host);
        }
        try {
            SecurityUtils.getSubject().login(token);
        }catch (UnknownAccountException u){
            log.error("", u.getMessage());
            return new CommonResponse(false,u.getMessage());
        } catch (AuthenticationException a){
            log.error("", a.getMessage());
            return new CommonResponse(false, a.getMessage());
        }catch (Exception e) {
            log.error("",e);
            return new CommonResponse(false, CommonResponse.SYS_EXCEPTION);
        }
        return new CommonResponse(true);
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            log.error("", e);
        }
        return "login";
    }
}
