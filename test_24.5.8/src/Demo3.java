import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: Demo3
 * Package: PACKAGE_NAME
 * Description:扫描指定目录，并找到名称或者内容中包含指定字符的所有普通文件（不包含目录）
 *
 * @Author 行空XKong
 * @Create 2024/5/11 11:06
 * @Version 1.0
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要扫描的根目录：");
        //String rootPath = scanner.next();
        String rootPath = "d:/1tmp";

        File rootDir = new File(rootPath);
        if (!rootDir.isDirectory()) {
            System.out.println("路径有误！");
            return;
        }

        System.out.print("请输入要查找的字符：");
        //String key = scanner.next();
        String key = "1";

        List<File> result = new ArrayList<>();
        scanDirWithContent(rootDir, key, result);
        System.out.println("共找到了" + result.size() +"个符合的文件，分别是：");
        for (File file : result) {
            System.out.println(file.getCanonicalPath());
        }
    }

    private static void scanDirWithContent(File rootDir, String key, List<File> result) throws IOException {
        File[] files = rootDir.listFiles();
        if (files == null || files.length == 0) return;

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirWithContent(file, key, result);
            } else {
                if (/* 缺少比较文件名字的方法，由于要进行字符串模糊匹配，遂作罢 */isContentContains(file, key)) {
                    result.add(file.getAbsoluteFile());
                }
            }
        }
    }

    private static boolean isContentContains(File file, String key) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(file)) {
            try (Scanner scanner = new Scanner(inputStream, "utf-8")) {
                while (scanner.hasNextLine()) {
                    stringBuilder.append(scanner.next());
                    stringBuilder.append("\r\n");
                }
            }
        }

        return stringBuilder.indexOf(key) != -1;
    }
}
