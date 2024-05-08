package io;

import java.io.*;

/**
 * ClassName: PrintWrite
 * Package: io
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/8 21:51
 * @Version 1.0
 */
public class PrintWrite {
    public static void main(String[] args) {
        //字节流转字符流
        try (OutputStream outputStream = new FileOutputStream("D:\\Github\\My\\JavaEE_exercise\\test_24.5.8/test.txt")) {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.printf("hello");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
