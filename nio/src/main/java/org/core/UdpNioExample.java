package org.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Iterator;

public class UdpNioExample {

    @Test
    public void send() throws IOException {
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        String msg = "Ping";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put((LocalDateTime.now().toString() + "\n" + msg).getBytes(StandardCharsets.UTF_8));
        buffer.flip();

        dc.send(buffer, new InetSocketAddress("127.0.0.1", 9898));
        buffer.clear();

        dc.close();
    }


    @Test
    public void receive() throws IOException {
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        dc.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();
        dc.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey sk = iterator.next();

                if (sk.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    dc.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
                    buffer.clear();
                }
            }

            iterator.remove();
        }
    }
}
