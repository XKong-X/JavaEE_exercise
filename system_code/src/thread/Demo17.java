package thread;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-09
 * Time: 16:11
 * Version:
 */
public class Demo17 {
    private volatile static int isQuit;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (isQuit == 0) {
                //System.out.println("t1 线程运行中");
            }
            System.out.println("t1 退出");
        });
        t1.start();

        Thread t2 = new Thread(()->{
            System.out.println("请输入 isQuit: ");
            Scanner scanner = new Scanner(System.in);
            isQuit = scanner.nextInt();
        });
        t2.start();
    }
}
