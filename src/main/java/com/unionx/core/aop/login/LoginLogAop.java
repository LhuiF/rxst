package com.unionx.core.aop.login;

import java.lang.annotation.*;

/**
 * 自定义注解 拦截登录 记录日志
 * @author abner
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoginLogAop {

    String value() default "";

}
