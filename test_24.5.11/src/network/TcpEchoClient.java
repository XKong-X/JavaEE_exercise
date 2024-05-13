package network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClassName: TcpEchoClient
 * Package: network
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/13 12:43
 * @Version 1.0
 */
public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        socket = new Socket(serverIp, serverPort);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            PrintWriter writer = new PrintWriter(outputStream);
            Scanner scannerNetwork = new Scanner(inputStream);
            while (true) {
                // 1. 读要发送的内容
                System.out.print("-> ");
                String request = scanner.next();
                // 2. 发给服务器
                writer.println(request);
                writer.flush();
                // 3. 读取服务器返回的响应
                String response = scannerNetwork.next();
                // 4. 显示内容
                System.out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1", 9090);
        tcpEchoClient.start();
    }
}
