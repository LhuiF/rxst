package com.unionx.core.aop.business;

import com.unionx.core.enums.StatusEnum;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.Identities;
import com.unionx.core.util.JsonUtils;
import com.unionx.sys.log.service.BusinessLogService;
import com.unionx.sys.log.vo.SysOptLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * business 切面类
 * @author abner
 */
@Aspect
@Component
@Slf4j
public class BusinessLogAspect {

    @Autowired
    BusinessLogService businessLogService;

    /**
     * 切点
     * @Author abner
     */
    @Pointcut("@annotation(com.unionx.core.aop.business.BusinessLogAop)")
    public void aspect() {

    }

    /**
     * 切面实现方法 保存业务日志信息
     * @Author abner
     */
    @Around("aspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        SysOptLog sysOptLog = new SysOptLog();
        long begin  = System.currentTimeMillis();
        Object object = null;
        try {
            sysOptLog.setId(Identities.uuid());
            Subject subject = SecurityUtils.getSubject();
            UserDetails userDetails = (UserDetails) subject.getPrincipal();
            sysOptLog.setUserId(userDetails.getId());
            sysOptLog.setLoginname(userDetails.getLoginName());
            sysOptLog.setUsername(userDetails.getName());
            sysOptLog.setOptName(getMethodDescription(proceedingJoinPoint));
            sysOptLog.setIp(userDetails.getHost());
            sysOptLog.setDetails(JsonUtils.writeValueAsString(proceedingJoinPoint.getArgs()));
            object = proceedingJoinPoint.proceed();
            sysOptLog.setOptStatus(StatusEnum.SUCCESS.getCode());
        }catch (Throwable throwable) {
            sysOptLog.setOptStatus(StatusEnum.FAILED.getCode());
            log.error("function BusinessLogAspect around\n",throwable);
        }finally {
            sysOptLog.setTimeConsuming(Integer.valueOf(String.valueOf(System.currentTimeMillis() - begin)));
            businessLogService.saveBusinessLog(sysOptLog);
            return object;
        }
    }

    /**
     * 方法的功能描述：获取自定义标签的返回值
     * @param joinPoint
     * @return String
     * @Author abner
     */
    public static String getMethodDescription(JoinPoint joinPoint) throws Exception {
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
                    description = method.getAnnotation(BusinessLogAop.class).value();
                    break;
                }
            }
        }
        return description;
    }
}
