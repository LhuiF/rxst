package com.unionx.core.aop.login;

import com.unionx.core.enums.StatusEnum;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.Identities;
import com.unionx.sys.log.service.LoginLogService;
import com.unionx.sys.log.vo.SysLoginLog;
import com.unionx.sys.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * loginlogaop 切面类
 * @author abner
 */
@Component
@Aspect
@Slf4j
public class LoginLogAspect {

    @Autowired
    private LoginLogService logManageService;

    /**
     * 方法的功能描述：登录切点
     * @Author abner
     * @Date 2016/3/15 11:43
     */
    @Pointcut("@annotation(com.unionx.core.aop.login.LoginLogAop)")
    public void aspect(){

    }

    /**
     * 方法的功能描述：登录日志（后置）
     * @Author abner
     * @Date 2016/3/15 11:41
     */
    @Around("aspect()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint){
        SysLoginLog sysLoginLog = new SysLoginLog();
        Object object = null;
        try {
            sysLoginLog.setId(Identities.uuid());
            Subject subject = SecurityUtils.getSubject();
            object = proceedingJoinPoint.proceed();
            UserDetails userDetails = (UserDetails) subject.getPrincipal();
            if(null!= userDetails){
                sysLoginLog.setIp(userDetails.getHost());
                sysLoginLog.setUserId(userDetails.getId());
                sysLoginLog.setLoginname(userDetails.getLoginName());
                sysLoginLog.setName(userDetails.getName());
                sysLoginLog.setStatus(StatusEnum.SUCCESS.getCode());
            }else{
                sysLoginLog.setLoginname(String.valueOf(proceedingJoinPoint.getArgs()[1]));
                sysLoginLog.setStatus(StatusEnum.FAILED.getCode());
            }
        } catch (Throwable throwable) {
            sysLoginLog.setStatus(StatusEnum.FUNCTIONEXCEPTION.getCode());
            log.error("登录异常",throwable);
        } finally {
            logManageService.saveLoginLog(sysLoginLog);
        }
        return object;
    }

    /**
     * 方法的功能描述：获取自定义标签的返回值
     * @Author abner
     * @param joinPoint
     * @return String
     * @Date 2016/3/15 11:36
     */
    public static String getMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(LoginLogAop.class).value();
                    break;
                }
            }
        }
        return description;
    }
}
