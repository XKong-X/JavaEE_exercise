package test1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *              有20个线程，需要同时启动。
 *              每个线程按0-19的序号打印，如第一个线程需要打印0
 *              请设计代码，在main主线程中，等待所有子线程执行完后，再打印 ok
 * Author: 行空XKong
 * Date: 2024-06-10
 * Time: 14:57
 * Version:
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int num = i;
            threads[i] = new Thread(() -> {
                System.out.println(num);
            });
        }

        long start = System.currentTimeMillis();

        for (Thread t : threads) {
            t.start();
            t.join();
        }

//        for (Thread t : threads) {
//            t.join();
//        }

        long end = System.currentTimeMillis();

        System.out.println("ok");
        // 实测，先全部启动再全部等待比启动一个就等待一个更快，但前者做不到按顺序打印0-19
        System.out.println(end - start);
    }
}
