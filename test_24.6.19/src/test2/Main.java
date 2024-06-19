package test2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA. 
 * Description: 
 * Author: 行空XKong
 * Date: 2024-06-19
 * Time: 23:42
 * Version: 
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // i++
                atomicInteger.getAndIncrement();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // ++i
                atomicInteger.incrementAndGet();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(atomicInteger);
    }
}
