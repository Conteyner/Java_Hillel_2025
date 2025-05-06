package org.lessons.lesson34.Client;

import lombok.extern.log4j.Log4j2;
import org.lessons.lesson34.Server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.out;

@Log4j2
public class Client implements Runnable {
    private final String name;
    private final Server server;
    private final Socket socket;
    private final CommandHandler commandHandler = new CommandHandler();

    public Client(String name, Server server, Socket socket) throws IOException {
        this.name = name;
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        log.info("Client " + name + " started");
        try(socket;
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                ) {
            out.println("Hello " + name + "!");

            boolean keepGoing = true;
            while (keepGoing) {
                String line = reader.readLine();
                keepGoing = commandHandler.handleCommand(line, this);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            server.removeClient(name);
            log.info("Client " + name + " stopped");
        }

    }
}
