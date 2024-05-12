package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * ClassName: UdpEchoClient
 * Package: network
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/11 23:57
 * @Version 1.0
 */
public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp = "";
    private int serverPort = 0;

    public UdpEchoClient(String ip, int port) throws SocketException {
        // 不能手动指定端口，让系统来分配
        socket = new DatagramSocket();
        // 记录 IP 和 端口
        this.serverIp = ip;
        this.serverPort = port;
    }

    public void start() throws IOException {
        System.out.println("客户端启动！");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 从控制台读取请求
            System.out.print("-> ");
            String request = scanner.next();
            // 2. 构造 DatagramPacket 对象，发给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            socket.send(requestPacket);
            // 3. 尝试读取服务器返回的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            // 4. 把响应转换成字符串，并显示出来
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}