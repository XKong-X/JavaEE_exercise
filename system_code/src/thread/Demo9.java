package thread;

public class Demo9 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 1. 假装没听见
                    e.printStackTrace();
                    // 2. 加个 break 让线程立即结束
                    //break;
                    // 3. 做一些其他工作再结束
                }
            }
        });

        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("让 t 线程终止");
        t.interrupt();
    }
}
