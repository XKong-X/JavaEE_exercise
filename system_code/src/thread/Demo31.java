package thread;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-18
 * Time: 22:19
 * Version:
 */
public class Demo31 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        // p 操作
        semaphore.acquire();
        System.out.println("p 操作");
        semaphore.acquire();
        System.out.println("p 操作");
        semaphore.acquire();
        System.out.println("p 操作");
        semaphore.acquire();
        System.out.println("p 操作");
        semaphore.acquire();
        System.out.println("p 操作");
        semaphore.acquire();
        System.out.println("p 操作");
        // v 操作
        //semaphore.release();
    }
}
