package com.xkong.demo.ioc;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-28
 * Time: 17:43
 * Version:
 */
public class Car {
    private Framework framework;

    public Car() {
        framework = new Framework();
        System.out.println("car init...");
    }

    public void run() {
        System.out.println("car run...");
    }
}
