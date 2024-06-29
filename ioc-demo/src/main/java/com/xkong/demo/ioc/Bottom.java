package com.xkong.demo.ioc;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-28
 * Time: 17:49
 * Version:
 */
public class Bottom {
    private Tire tire;

    public Bottom() {
        tire = new Tire();
        System.out.println("bottom init...");
    }
}
