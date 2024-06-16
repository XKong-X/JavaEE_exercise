package thread;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-16
 * Time: 15:42
 * Version:
 */
class MyTimerTask implements Comparable<MyTimerTask>{
    // 要执行的任务
    private Runnable runnable;
    // 执行时间
    private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
    }

    public long getTime() {
        return time;
    }

    public Runnable getRunnable() {
        return runnable;
    }
}

class MyTimer {
    private Object locker = new Object();

    // 用优先级队列来保存所有任务
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();

    public void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            queue.offer(new MyTimerTask(runnable, delay));
            locker.notify();// 有新线程时唤醒 wait
        }
    }

    // 扫描线程
    public MyTimer() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        if (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        // 判断是否已到定时时间
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.getTime()) {
                            task.getRunnable().run();
                            queue.poll();
                        } else {
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}

public class MyTimerAndTimerTask {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        }, 3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        }, 2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        }, 1000);
    }
}
