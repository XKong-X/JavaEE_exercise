package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-16
 * Time: 18:39
 * Version:
 */
public class Demo27 {
    public static void main(String[] args) {
        // 自适应线程池
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
//        // 固定数量线程池
//        ExecutorService service2 = Executors.newFixedThreadPool(4);
//        // 下面两个不常用
//        // 单线程池
//        ExecutorService service3 = Executors.newSingleThreadExecutor();
//        // 定时线程池
//        ExecutorService service4 = Executors.newScheduledThreadPool(4);
    }
}
