import java.io.*;
import java.util.Scanner;

/**
 * ClassName: Demo2
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/10 21:38
 * @Version 1.0
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //获取源文件的路径
        System.out.println("请输入要复制的文件的路径：");
//        String srcPath = scanner.next();
        String srcPath = "d:/1tmp/111/1.txt";
        File srcFile = new File(srcPath);
        if (!srcFile.exists()) {
            System.out.println("文件不存在！");
            return;
        }
        if (!srcFile.isFile()) {
            System.out.println("文件不是普通文件！");
            return;
        }

        //设置目标文件的路径
        System.out.println("请输入要粘贴的文件的路径：");
//        String destPath = scanner.next();
        String destPath = "d:/2tmp/1.png";
        File destFile = new File(destPath);

        //执行复制粘贴过程
        try (InputStream inputStream = new FileInputStream(srcFile) ) {
            try (OutputStream outputStream = new FileOutputStream(destFile)) {
                byte[] buf = new byte[1024];
                while (inputStream.read(buf) != -1) {
                    outputStream.write(buf);
                }
                outputStream.flush();
                System.out.println("粘贴完成！");
            }
        }
    }
}
