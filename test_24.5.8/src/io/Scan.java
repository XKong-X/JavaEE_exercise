package io;

import java.io.*;
import java.util.Scanner;

/**
 * ClassName: Scanne
 * Package: io
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/8 21:43
 * @Version 1.0
 */
public class Scan {
    public static void main(String[] args) {
        //字节流转字符流
        try (InputStream inputStream = new FileInputStream("D:\\Github\\My\\JavaEE_exercise\\test_24.5.8/test.txt")) {
            //用 Scanner 来读文件
            Scanner scanner = new Scanner(inputStream);
            String str = scanner.next();
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
