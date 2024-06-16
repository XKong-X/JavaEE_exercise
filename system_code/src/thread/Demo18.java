package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description: 定时器
 * Author: 行空XKong
 * Date: 2024-06-13
 * Time: 22:10
 * Version:
 */
public class Demo18 {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        }, 3000);
        // 定时
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        }, 2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        }, 1000);

        System.out.println("程序启动！");
    }
}
