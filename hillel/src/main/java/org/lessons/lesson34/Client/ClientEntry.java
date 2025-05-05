package org.lessons.lesson34.Client;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Log4j2
public class ClientEntry {
    private static final String HOST = "localhost";
    private static final int PORT = 1111;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT)) {

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello, Server!");


            String response = input.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
        }

    }
}
