/**
 * Created with IntelliJ IDEA.
 * Description:
 * 提供：可以通过 synchronized 或者 Lock 来实现一个死锁代码。
 * 所谓的死锁就是线程一拥有锁1，线程二拥有锁2，双方在拥有自身锁的同时尝试获取对方的锁
 * 最终两个线程就会进入无线等待的状态，这就是死锁
 * Author: 行空XKong
 * Date: 2024-06-10
 * Time: 19:34
 * Version:
 */
public class Demo1 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                System.out.println("t1 线程获取 locker1 成功，正在尝试获取 locker1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (locker2) {
                    System.out.println("locker2 获取成功");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (locker2) {
                System.out.println("t2 线程获取 locker2 成功，正在尝试获取 locker1...");
                synchronized (locker1) {
                    System.out.println("locker1 获取成功");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
