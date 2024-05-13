package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: TcpEchoServer
 * Package: network
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/13 11:49
 * @Version 1.0
 */
public class TcpEchoServer {
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动！");
        ExecutorService service = Executors.newCachedThreadPool();//线程池
        while (true) {
            // 通过 accept 方法把内核中建立好的连接拿到
            Socket clientSocket = serverSocket.accept();
//            // 创建新线程（多线程）
//            Thread t = new Thread(() -> {
//                processConnection(clientSocket);
//            });
//            t.start();
            service.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    //处理连接
    private void processConnection(Socket clientSocket) {
        // 打印日志
        System.out.printf("[%s:%d] 客户端上线\n", clientSocket.getInetAddress(), clientSocket.getPort());
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            while (true) {
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    System.out.printf("[%s:%d] 客户端下线\n", clientSocket.getInetAddress(), clientSocket.getPort());
                    break;
                }
                // 1. 读取请求解析
                String request = scanner.next();
                // 2. 计算响应
                String response = process(request);
                // 3. 把响应写回客户端
                // 把 outputStream 包裹一下，来写入字符串
                PrintWriter printWriter = new PrintWriter(outputStream);
                // 这里的 println 不是打印到控制台，而是写入到 outputStream 中了
                printWriter.println(response);
                printWriter.flush();
                System.out.printf("[%s:%d] req=%s resp=%s\n", clientSocket.getInetAddress(), clientSocket.getPort(),
                        request, response);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();
    }
}
