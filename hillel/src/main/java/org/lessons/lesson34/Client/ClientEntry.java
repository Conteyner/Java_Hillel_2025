package org.lessons.lesson34.Client;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.in;
import static java.lang.System.out;

@Log4j2
public class ClientEntry {
    private static final String HOST = "localhost";
    private static final int PORT = 1111;

    public static void main(String[] args) {
           try(
                   Socket sock = new Socket(HOST,PORT);
                   BufferedReader bf = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                   PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
                   BufferedReader bdReader = new BufferedReader(new InputStreamReader(in))) {
               new Thread(() -> {
                   try {
                       String serv;
                       while ((serv = bf.readLine()) != null)
                           out.println("server " + serv);
                   } catch (IOException i) {
                       log.error(i);
                   }
               }).start();
               String line;
               while ((line = bdReader.readLine()) != null) {
                   out.println("client " + line);
                   if ("exit".equals(line)) break;
               }
           }

           catch (IOException e) {
               log.error(e);
           }
    }
}
