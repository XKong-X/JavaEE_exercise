package thread;

public class Demo13 {
    private static int count;

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                synchronized(locker) {
                    count++;
                }
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 5_0000; i++) {
                synchronized (locker) {
                    count++;
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
