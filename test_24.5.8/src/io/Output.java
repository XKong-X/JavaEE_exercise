package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * ClassName: Output
 * Package: io
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/8 21:30
 * @Version 1.0
 */
public class Output {
    public static void main(String[] args) {
        //默认清空原内容
        try (OutputStream outputStream = new FileOutputStream("D:\\Github\\My\\JavaEE_exercise\\test_24.5.8/test.txt", true)) {
            String str = "你好";
            //这里的 write 没有字符串版，得转成字节（byte）
            outputStream.write(str.getBytes());//
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
