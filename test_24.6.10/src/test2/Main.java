package test2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 有三个线程，线程名称分别为：a，b，c
 * 每个线程打印自己的名称
 * 需要让他们同时启动，并按 c，b，a的顺序打印
 * Author: 行空XKong
 * Date: 2024-06-10
 * Time: 16:08
 * Version:
 */
public class Main {
    public static void main(String[] args) {
        Thread c = new Thread(() -> {
            System.out.print("c");
        });
        Thread b = new Thread(() -> {
            try {
                c.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("b");
        });
        Thread a = new Thread(() -> {
            try {
                b.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("a");
        });

        a.start();
        b.start();
        c.start();
    }
}
