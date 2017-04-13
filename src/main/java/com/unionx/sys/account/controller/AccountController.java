package com.unionx.sys.account.controller;

import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.cache.RedisStringTemplate;
import com.unionx.core.message.SendMessage;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.JsonUtils;
import com.unionx.core.vo.CommonResponse;
import com.unionx.sys.account.service.AccountService;
import com.unionx.sys.account.vo.Account;
import com.unionx.sys.user.service.UserService;
import com.unionx.sys.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author abner
 */
@Controller
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Resource
    private UserService userService;

    @Resource
    private RedisStringTemplate redisStringTemplate;

    @Resource
    private SendMessage sendMessage;

    /**
     * 修改密码
     * @author abner
     * @return
     */
    @BusinessLogAop("修改密码")
    @ResponseBody
    @RequestMapping("/updatePassWord")
    public CommonResponse updatePassWord(String passWord ,String newPassWord){
        try{
            UserDetails userDetails = (UserDetails) SecurityUtils.getSubject().getPrincipal();
            int i = accountService.updateUserPassword(userDetails.getId(), DigestUtils.sha256Hex(passWord), DigestUtils.sha256Hex(newPassWord));
            if(i>0){
                return new CommonResponse(true,CommonResponse.UPDATE_PASSWORD_SUCCESS);
            }else{
                return new CommonResponse(false, CommonResponse.UPDATE_PASSWORD_EXCEPTION);
            }
        }catch (Exception e){
            log.error("",e);
            return new CommonResponse(false, CommonResponse.SYS_EXCEPTION);
        }
    }

    /**
     * 重置密码
     *
     * @param id
     * @return
     */
    @BusinessLogAop("重置密码")
    @ResponseBody
    @RequestMapping("/resetPassword")
    public CommonResponse resetPassword(String id) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            this.accountService.updatePassword(id);
            commonResponse.setSuccess(true);
            commonResponse.setMessage("密码已重置!");
        } catch (Exception e) {
            log.error("", e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 根据帐号查询手机号发送验证码
     * @author abner
     * @param loginName
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPhonenumberAndVerifycodeByAccount")
    public CommonResponse getPhonenumberAndVerifycodeByAccount(String loginName,String kefuorstore){
        CommonResponse commonResponse = new CommonResponse();
        try{
            Account account = this.accountService.getAccountByLoginName(loginName, kefuorstore);
            HashMap<String, Object> map = new HashMap<>();
            if(null != account){
                String phone=null;
                if(kefuorstore.equals("1")){
                    User user = this.userService.getUserById(account.getUserId());
                    phone = user.getPhone();
                    map.put("phone", phone);
                }else if(kefuorstore.equals("2")){
                    phone = this.userService.getStoreUserPhoneById(account.getUserId());
                    map.put("phone", phone);
                }
                String code = RandomStringUtils.randomNumeric(4);
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("code", code);
                String smsParam = JsonUtils.writeValueAsString(paramMap);
                sendMessage.sendMessage(smsParam, phone, "SMS_14206655");
                redisStringTemplate.put(loginName, code.getBytes(),300);
                commonResponse.setData(map);
                commonResponse.setSuccess(true);
            }else{
                commonResponse.setSuccess(false);
            }
        }catch (Exception e){
            log.error("",e);
            commonResponse.setSuccess(false);
        }
        return commonResponse;
    }

    /**
     * 找回密码
     * @author abner
     * @param loginName
     * @return
     */
    @ResponseBody
    @RequestMapping("/forgetPassword")
    public CommonResponse forgetPassword(String loginName,String password,String code){
        CommonResponse commonResponse = new CommonResponse();
        try{
            byte[] bytes = redisStringTemplate.get(loginName);
            String s = new String(bytes, "UTF-8");
            if(s.equals(code)){
                password = DigestUtils.sha256Hex(password);
                this.accountService.forgetPassword(loginName,password);
                commonResponse.setSuccess(true);
            }else{
                commonResponse.setSuccess(false);
            }
        }catch (Exception e){
            log.error("",e);
            commonResponse.setSuccess(false);
        }
        return commonResponse;
    }
}
