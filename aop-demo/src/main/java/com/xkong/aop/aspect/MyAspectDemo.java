package com.xkong.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-26
 * Time: 20:06
 * Version:
 */
@Slf4j
@Component
@Aspect
public class MyAspectDemo {
    @Before("@annotation(com.xkong.aop.aspect.MyAspect)")
    public void doBefore() {
        log.info("执行Aspect...");
    }

//    @After("execution(* com.xkong.aop.controller.*.*(..))")
//    public void doAfter() {
////        log.info("执行Aspect...");
//    }
}
