package com.xkong.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-07
 * Time: 14:40
 * Version:
 */
@Slf4j
@RestController
public class LoggerController {
//    private static Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @PostConstruct
    public void print() {
        log.info("=========框架日志=========");
        log.error("error 日志");
        log.warn("warn 日志");
        log.info("info 日志");
        log.debug("debug 日志");
        log.trace("trace 日志");
    }
}
