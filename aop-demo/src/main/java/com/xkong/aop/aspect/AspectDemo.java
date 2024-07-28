package com.xkong.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-26
 * Time: 15:46
 * Version:
 */
@Slf4j
@Aspect
@Component
public class AspectDemo {
    @Pointcut("execution(* com.xkong.aop.controller.*.*(..))")
    private void pt() {

    }

    @Before("execution(* com.xkong.aop.controller.*.*(..))")
    public void doBefore() {
        log.info("执行Aspect...");
    }

    @After("execution(* com.xkong.aop.controller.*.*(..))")
    public void doAfter() {
//        log.info("执行Aspect...");
    }

    @AfterReturning("execution(* com.xkong.aop.controller.*.*(..))")
    public void doAfterReturning() {
//        log.info("执行Aspect...");
    }

    @AfterThrowing("execution(* com.xkong.aop.controller.*.*(..))")
    public void doAfterThrowing() {
//        log.info("执行Aspect...");
    }

    @Around("execution(* com.xkong.aop.controller.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("执行 Around 前...");
        Object result = joinPoint.proceed();
        log.info("执行 Around 后...");
        return result;
    }
}
