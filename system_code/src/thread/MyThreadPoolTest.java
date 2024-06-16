package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-16
 * Time: 20:13
 * Version:
 */
class MyThreadPool {
    // 任务队列
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    public void submit(Runnable runnable) throws InterruptedException {
        // 这里的拒绝策略是阻塞等待（标准库中没有）
        queue.put(runnable);
    }

    public MyThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                // 取线程并执行
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }
    }
}

public class MyThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            //final int n = i;
            int n = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务：" + n);
                }
            });
        }
    }
}
