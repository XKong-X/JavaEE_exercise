package io;

import java.io.*;

/**
 * ClassName: Input
 * Package: io
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/8 21:25
 * @Version 1.0
 */
public class Input {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("D:\\Github\\My\\JavaEE_exercise\\test_24.5.8/test.txt")) {
            byte[] buffer = new byte[1024];
            int n = inputStream.read(buffer);
            System.out.println("n = " + n);
            for (int i = 0; i < n; i++) {
                System.out.printf("%x ", buffer[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
