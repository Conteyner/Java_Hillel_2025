package org.lessons.lesson34.Client;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Log4j2
public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 1111;

    public static void main(String[] args) {
        try(
                Socket socket = new Socket(HOST, PORT);
                var console = new BufferedReader(new InputStreamReader(System.in));
                var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                var writer = new PrintWriter(socket.getOutputStream(), true))
        {
            log.info("Connected to server " + HOST + ":" + PORT);
            log.info("Enter the message. If you want to leave - just print 'exit'.");

            new Thread(() -> {
                try {
                    String resp;
                    while ((resp = reader.readLine()) != null) {
                        System.out.println("Server: " + resp);
                    }
                } catch (IOException ignored) {

                } }
            ).start();

            String line;
            while ((line = console.readLine()) != null) {
                writer.println(line);
                if ("exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
            }
        } catch (IOException e) {
            log.error(e);
        }
    }
}
