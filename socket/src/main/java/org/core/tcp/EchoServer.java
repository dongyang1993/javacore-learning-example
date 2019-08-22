package org.core.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try(final ServerSocket server = new ServerSocket(10086)) {
            try(final Socket accept = server.accept()) {
                final InputStream in = accept.getInputStream();
                final OutputStream out = accept.getOutputStream();
                try(final Scanner sc = new Scanner(in, "UTF-8")){
                    final PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"), true);
                    writer.println("Hello!!!!!");

                    boolean done = false;
                    while (!done&&sc.hasNextLine()) {
                        String line = sc.nextLine();
                        writer.println("Echo: " + line);
                        if (line.trim().equals("BYE")) {
                            done = true;
                        }
                    }

                }
            }
        }
    }
}
