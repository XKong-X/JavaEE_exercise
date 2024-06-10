package test3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 有三个线程，分别只能打印A，B和C
 * 要求按顺序打印ABC，打印10次
 * Author: 行空XKong
 * Date: 2024-06-10
 * Time: 16:39
 * Version:
 */
public class Main {
//    // 方法一（只有一个锁）
//    private static volatile int count;
//    //private static Object locker = new Object();
//    public static void main(String[] args) {
//        Object locker = new Object();
//        // 线程a
//        Thread a = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (locker) {
//                    while (count % 3 != 0) {
//                        try {
//                            locker.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    System.out.print("A");
//                    count++;
//                    locker.notifyAll();
//                }
//            }
//        });
//
//        // 线程b
//        Thread b = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (locker) {
//                    while (count % 3 != 1) {
//                        try {
//                            locker.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    System.out.print("B");
//                    count++;
//                    locker.notifyAll();
//                }
//            }
//        });
//
//        // 线程c
//        Thread c = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (locker) {
//                    while (count % 3 != 2) {
//                        try {
//                            locker.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    System.out.println("C");
//                    count++;
//                    locker.notifyAll();
//                }
//            }
//        });
//
//        a.start();
//        b.start();
//        c.start();
//    }

    // 方法二（三个锁，即每个线程都有一把锁）
    public static void main(String[] args) throws InterruptedException {
        Object lockerA = new Object();
        Object lockerB = new Object();
        Object lockerC = new Object();
        Thread a = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (lockerA) {
                    try {
                        lockerA.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("A");
                synchronized (lockerB) {
                    lockerB.notify();
                }
            }
        });

        Thread b = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (lockerB) {
                    try {
                        lockerB.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("B");
                synchronized (lockerC) {
                    lockerC.notify();
                }
            }
        });

        Thread c = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (lockerC) {
                    try {
                        lockerC.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("C");
                synchronized (lockerA) {
                    lockerA.notify();
                }
            }
        });

        a.start();
        b.start();
        c.start();

        Thread.sleep(1000);// 休眠 1s 等待线程全部进入等待状态

        // 从 a 线程启动
        synchronized (lockerA) {
            lockerA.notify();// 所有线程启动后立刻进入等待状态（释放锁）因此此处能顺利获取到锁
        }
    }
}
