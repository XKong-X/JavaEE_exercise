package thread;

// 创建一个类来继承 Thread
class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        // run 只是描述了线程入口（线程要做什么）
        // start 则是真正调用了系统 api，创建线程在让线程调用 run
        t.start();
        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
