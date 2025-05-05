package org.lessons.lesson34.Server;

import lombok.extern.log4j.Log4j2;
import org.lessons.lesson34.Client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class Server {
    private final int port;
    private final ExecutorService pool;
    private final AtomicInteger count = new AtomicInteger(1);
    private final Map<String, Client> clients = new HashMap<>();

    public Server(int port) {
        this.port = port;
        this.pool = Executors.newCachedThreadPool();
    }

    protected void start() throws IOException {
        log.info("Starting server on port {}", port);
        try (var serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                var name = "client-" + count.getAndIncrement();
                var client = new Client();
                clients.put(name, client);
                pool.submit(client);
                log.info("server "+name+" connected");
            }
        } finally {
            pool.shutdown();
        }
    }

    protected void removeClient(String name) {
        clients.remove(name);
        log.info("removing client {}", name);
    }

}
