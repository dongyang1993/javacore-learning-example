package org.core.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        try(final Socket socket = new Socket("127.0.0.1", 10086)) {
            final OutputStream out = socket.getOutputStream();
            out.write("HELLO WORLD DDD".getBytes());
            final InputStream in = socket.getInputStream();
            final Scanner scanner = new Scanner(in, "UTF-8");
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                System.out.println(line);
            }

        }
    }
}
