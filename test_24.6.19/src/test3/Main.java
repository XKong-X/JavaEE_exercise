package test3;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:编写代码, 基于 CountDownLatch 模拟跑步比赛的过程
 * Author: 行空XKong
 * Date: 2024-06-19
 * Time: 15:00
 * Version:
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("选手到达终点");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        // 必须等到 10 人全部回来
        latch.await();
        System.out.println("比赛结束");
    }
}
