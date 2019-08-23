package org.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Iterator;

public class TcpNioExample {

    @Test
    public void client() throws IOException {
        //1. 获取通道
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        //2. 切换非阻塞模式
        channel.configureBlocking(false);

        //3. 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //4. 发送数据给服务端
        String msg = "Ping";
        buffer.put((LocalDateTime.now().toString() + "\n" + msg).getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        channel.write(buffer);
        buffer.clear();

        //5. 关闭通道
        channel.close();
    }


    @Test
    public void server() throws IOException {
        //1. 获取通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        //2. 切换到非阻塞模式
        serverChannel.configureBlocking(false);

        //3. 绑定连接
        serverChannel.bind(new InetSocketAddress(9898));

        //4. 获取选择器
        Selector selector = Selector.open();

        //5. 将通道注册到选择器上， 并指定"监听接收事件"
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6. 轮询式地获取选择器上已经"准备就绪"的事件
        while (selector.select() > 0) {
            //7. 获取当前选择器中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                //8. 获取“准备就绪”的事件
                SelectionKey sk = iterator.next();

                //9. 判断具体是什么事件准备就绪
                if (sk.isAcceptable()) {
                    //10. 若“接收就绪”， 获取客户端连接
                    SocketChannel socketChannel = serverChannel.accept();

                    //11. 切换非阻塞模式
                    socketChannel.configureBlocking(false);

                    //12. 将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    //13. 获取当前选择器上“读就绪”状态的通道
                    SocketChannel channel = (SocketChannel) sk.channel();

                    //14. 读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int len = 0;
                    while ((len = channel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }

                //15. 取消选择键SelectionKey
                iterator.remove();
             }
        }

    }


}
