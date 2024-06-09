package thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-09
 * Time: 23:56
 * Version:
 */
class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    // 把构造方法设为私有，类外面的其他代码就没法 new 出这个类对象
    private Singleton() {}
}
public class Demo21 {
    public static void main(String[] args) {
        //Singleton singleton = new Singleton();// 编译不通过
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
