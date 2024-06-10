package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-10
 * Time: 0:03
 * Version:
 */
class SingletonLazy {
    private static volatile SingletonLazy instance = null;

    public static SingletonLazy getInstance() {
        // 判断是否已加过锁，从而避免重复加锁
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                // 判断是否已有实例
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    // 把构造方法设为私有，类外面的其他代码就没法 new 出这个类对象
    private SingletonLazy() {}
}

public class Demo22 {
    public static void main(String[] args) {

    }
}
