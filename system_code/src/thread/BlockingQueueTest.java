package thread;

import java.sql.SQLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-10
 * Time: 22:26
 * Version:
 */
class MyBlackingQueue {
    private String[] data = new String[1000];
    private volatile int head;
    private volatile int tail;
    private volatile int size;

    public synchronized void put(String elem) throws InterruptedException {
        while (size == data.length) {
            // 队列满了，进入阻塞状态
            wait();
        }
        data[tail] = elem;
        ++tail;
        // 到达数组末尾后直接回到开头
        if (tail == data.length) {
            tail = 0;
        }
        ++size;
        notify();
    }

    public String take() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                // 队列为空，进入阻塞状态
                wait();
            }
            String ret = data[head];
            head++;
            if (head == data.length) {
                head = 0;
            }
            size--;
            notify();
            return ret;
        }
    }
}

public class BlockingQueueTest {
    public static void main(String[] args) {
        MyBlackingQueue queue = new MyBlackingQueue();

        // 消费者
        Thread t1 = new Thread(()->{
            while (true) {
                try {
                    String result = queue.take();
                    System.out.println("消费的元素：" + result);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 生产者
        Thread t2 = new Thread(()->{
            int num = 1;
            while (true) {
                try {
                    queue.put(num + "");// 加空字符串把 int 类型转换成 String 类型
                    System.out.println("生产的元素：" + num++);
                    //Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
