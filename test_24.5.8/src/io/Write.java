package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * ClassName: Write
 * Package: io
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/8 20:33
 * @Version 1.0
 */
public class Write {
    public static void main(String[] args) {
        //会覆盖之前的数据
        try (Writer writer = new FileWriter("D:\\Github\\My\\JavaEE_exercise\\test_24.5.8/test.txt")) {
            writer.write("文件写入练习");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //不会覆盖之前的数据，直接在末尾追加
        try (Writer writer = new FileWriter("D:\\Github\\My\\JavaEE_exercise\\test_24.5.8/test.txt", true)) {
            writer.write("文件写入练习");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
