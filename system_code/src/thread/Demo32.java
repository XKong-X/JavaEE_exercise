package thread;

import java.util.Timer;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-18
 * Time: 22:48
 * Version:
 */
public class Demo32 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int n = i;
            Thread t = new Thread(() -> {
                System.out.println("thread: " + n);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();// 通知任务执行完成
            });
            t.start();
        }
        countDownLatch.await();
        System.out.println("全部执行完成！");
    }
}
