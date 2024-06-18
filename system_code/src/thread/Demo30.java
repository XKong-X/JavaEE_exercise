package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-17
 * Time: 23:19
 * Version:
 */
public class Demo30 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 定义任务
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        // 把任务放进线程里执行
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();

        // get 能获取到 callable 里面的返回结果
        // 没执行完 get 会阻塞
        System.out.println(futureTask.get());
    }
}
