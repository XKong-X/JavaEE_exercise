package com.xkong.demo.ioc;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-28
 * Time: 17:44
 * Version:
 */
public class Framework {
    private Bottom bottom;

    public Framework() {
        bottom = new Bottom();
        System.out.println("framework init...");
    }
}
