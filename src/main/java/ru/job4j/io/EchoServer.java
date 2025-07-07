package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String requestLine = input.readLine();
                    System.out.println(requestLine);

                        output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        if (requestLine.contains("GET /?msg=Hello")) {
                            output.write("Hello bro".getBytes());
                        } else if (requestLine.contains("GET /?msg=Bye")) {
                            System.out.println("End server work");
                            output.write("End server work on clent".getBytes());
                            output.flush();
                            server.close();
                        }
                        output.flush();
                }
            }
        }
    }
}
