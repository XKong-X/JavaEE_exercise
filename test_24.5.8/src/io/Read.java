package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * ClassName: io.Demo
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/8 19:48
 * @Version 1.0
 */
public class Read {
    public static void main(String[] args) throws IOException {
        //Reader reader = new FileReader("D:\\Github\\My\\JavaEE_exercise\\test_24.5.8/test.txt");

//        //一次 read 一个字符
//        while (true) {
//            int c = reader.read();
//            if (c == -1) {
//                //读取完毕
//                break;
//            }
//            char ch = (char)c;
//            System.out.println(ch);
//        }

//        try {
//            //一次 read 多个字符
//            while (true) {
//                char[] cbuf = new char[1024];
//                //n 是读取到的字符的个数
//                int n = reader.read(cbuf);
//                if (n == -1) {
//                    //读取完毕
//                    break;
//                }
//                System.out.println("n = " + n);
//                for (int i = 0; i < n; i++) {
//                    System.out.println(cbuf[i]);
//                }
//            }
//        } finally {
//            reader.close();
//        }

        //括号中的内容会自动 close，流对象都可以这么写
        try (Reader reader = new FileReader("D:\\Github\\My\\JavaEE_exercise\\test_24.5.8/test.txt")) {
            while (true) {
                char[] cbuf = new char[1024];
                //n 是读取到的字符的个数
                int n = reader.read(cbuf);
                if (n == -1) {
                    //读取完毕
                    break;
                }
                System.out.println("n = " + n);
                for (int i = 0; i < n; i++) {
                    System.out.println(cbuf[i]);
                }
            }
        }
    }
}
