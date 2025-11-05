package com.lq.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description @Enable模块驱动的本质就是结合@Import注解来实现的
 * @Author liqiang
 * @Date 2025-11-05 17:14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWordConfiguration.class)
public @interface EnableHelloWord  {
}
