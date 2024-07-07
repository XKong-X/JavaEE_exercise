package com.xkong.captcha.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-07
 * Time: 11:49
 * Version:
 */
@RequestMapping("/home")
@RestController
public class CaptchaController {
    // 企业开发标准
    // key全大写，value全小写
    private static final String KAPTCHA_SESSION_KEY = "HOME_KAPTCHA_SESSION_KEY";
    // 验证码的生成时间
    private static final String KAPTCHA_SESSION_DATE = "HOME_KAPTCHA_SESSION_DATE";
    // 验证码的有效时间
    private static final Long SESSION_TIMEOUT = 60 * 1000L;
    // 从 Session 中读取生成的验证码
    // 对比前端传来的验证码
    @RequestMapping("/check")
    public Boolean check(String captcha, HttpSession session) {
        if (!StringUtils.hasLength(captcha)) {
            return false;
        }
        // 从 Session 中获取验证码和生成时间
        String saveCaptcha = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        Date saveDate = (Date) session.getAttribute(KAPTCHA_SESSION_DATE);
        // 对比验证码
        if (captcha.equals(saveCaptcha)) {
            // 对比时间
            if (saveDate == null || System.currentTimeMillis() - saveDate.getTime() < SESSION_TIMEOUT) {
                return true;
            }
        }
        return false;
    }
}
