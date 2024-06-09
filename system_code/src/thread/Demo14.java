package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-09
 * Time: 14:27
 * Version:
 */
class Counter {
    public int count;

    synchronized public void increase() {
        count++;
    }
}

public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.count);
    }
}
