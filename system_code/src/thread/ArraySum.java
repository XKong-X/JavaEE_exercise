package thread;

import java.util.Random;

public class ArraySum {
    private static int sum1;
    private static int sum2;

    private static int[] init() throws InterruptedException {
        Random random = new Random();
        int[] array = new int[10_000_000];
        for (int i = 0; i < 10_000_000; ++i) {
            array[i] = random.nextInt(100) + 1;
        }
        return array;
    }

    public static void main(String[] args) throws InterruptedException {
        // 计时
        long start = System.currentTimeMillis();
        // 创建数组 (长度 1000w), 通过随机数的方式生成 1-100 之间的整数
        int[] array = init();
//        for (int x : array) {
//            System.out.println(x);
//        }
        // 创建两个线程, 对这个数组的所有元素求和;其中线程1 计算偶数下标元素的和, 线程2 计算奇数下标元素的和.
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array.length; i += 2) {
                    sum1 += array[i];
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i < array.length; i += 2) {
                sum2 += array[i];
            }
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();
        // 汇总两个和, 进行相加
        int sum = sum1 + sum2;
        System.out.println(sum);
        // 程序的执行时间
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
