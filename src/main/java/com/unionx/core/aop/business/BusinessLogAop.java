package com.unionx.core.aop.business;

import java.lang.annotation.*;

/**
 * 自定义注解 业务日志拦截
 * @author abner
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface BusinessLogAop {

    String value() default "";
}
