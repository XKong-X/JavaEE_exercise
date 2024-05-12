package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ClassName: UdpEchoServer
 * Package: network
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/12 0:03
 * @Version 1.0
 */
public class UdpEchoServer {
    // 创建 DatagramSocket 对象
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        // 手动指定端口
        socket = new DatagramSocket(port);
//        // 系统自动分配端口
//        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true) {
            // 1. 读取请求解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            // 这里 receive 之后，数据是以二进制的形式存入了 DatagramPacket(requestPacket) 中了
            // 要转成字符串才能显示出来
            // getLength 获取的是实际存入的长度
            String request = new String(requestPacket.getData(), 0,
                    requestPacket.getLength());
            // 2. 根据请求计算响应
            String response  = process(request);
            // 3. 把响应写回客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);
            // 4. 打印日志
            System.out.printf("[%s:%d] req=%s, resp=%s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    // 由于是回显服务器，请求和响应一样
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}