package test4;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 使用ThreadPoolExecutor创建一个忽略最新任务的线程池，创建规则：
 * 1.核心线程数为5
 * 2.最大线程数为10
 * 3.任务队列为100
 * 4.拒绝策略为忽略最新任务
 * Author: 行空XKong
 * Date: 2024-06-19
 * Time: 15:20
 * Version:
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10,
                1000, TimeUnit.MILLISECONDS, queue, Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("自定义线程池成功！");
            }
        });
    }
}
