import java.io.File;
import java.util.Scanner;

/**
 * ClassName: Demo1
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/8 23:00
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //输入要扫描的路径
        System.out.print("请输入要扫描的路径：");
        String path = scanner.next();
        File rootPath = new File(path);
        if (!rootPath.isDirectory()) {
            System.out.println("输入的路径有误！");
            return;
        }

        //输入文件名
        System.out.print("请输入要删除的文件的关键字：");
        String word = scanner.next();

        //扫描
        scanDir(rootPath, word);
    }

    private static void scanDir(File rootPath, String word) {
        File[] files = rootPath.listFiles();
        if (files == null) {
            return;
        }
        //遍历
        for (File f : files) {
            System.out.println("当前文件：" + f.getAbsolutePath());
            if (f.isFile()) {
                //判断文件是否要删除
                checkDelete(f, word);
            } else {
                //继续递归判断
                scanDir(f, word);
            }
        }
    }

    private static void checkDelete(File f, String word) {
        if (!f.getName().contains(word)) {
            //不删除
            return;
        }
        //删除
        System.out.println("当前文件：" + f.getAbsolutePath() + "是否要删除（Y/N）：");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equals("Y") || choice.equals("y")) {
            f.delete();
            System.out.println("删除完毕！");
        } else {//输入其他值就取消
            System.out.println("取消删除！");
        }
    }
}
