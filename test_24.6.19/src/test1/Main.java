package test1;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-19
 * Time: 13:11
 * Version:
 */
public class Main {
    private static int n;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                try {
                    semaphore.acquire();
                    n++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                try {
                    semaphore.acquire();
                    n++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(n);
    }
}
