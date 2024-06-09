package thread;

import javax.sound.midi.Soundbank;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-09
 * Time: 23:01
 * Version:
 */
public class Demo20 {
    public static void main(String[] args) {
        Object locker = new Object();

        Thread t1 = new Thread(()->{
            synchronized (locker) {
                System.out.println("wait 之前");
                try {
                    locker.wait(3000);// 3000 是等待的超时时间
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("wait 之后");
            }
        });

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (locker) {
                System.out.println("通知等待结束");
                locker.notify();
            }
        });

        t1.start();
        t2.start();
    }
}
