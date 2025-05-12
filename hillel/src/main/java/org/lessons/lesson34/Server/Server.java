package org.lessons.lesson34.Server;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class Server {
    private final int port;
    private final ServerSocket serverSocket;
    private final ExecutorService pool = Executors.newCachedThreadPool();
    private final AtomicInteger count = new AtomicInteger(1);
    private final Map<String, ClientHandler> clients  = new ConcurrentHashMap<>();

    public Server(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
    }

    protected void start() throws IOException {
        log.info("Starting server on port {}", port);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                var name = "client-" + count.getAndIncrement();
                var handler = new ClientHandler(name, socket );
                clients .put(name, handler);
                pool.submit(handler);
                log.info("[SERVER] {} successfully connected", name);
            }

        }
        catch (IOException e) {
            log.error(e);
        }
        finally {
            shutdown();
        }
    }

    private void shutdown() {
        try {
            pool.shutdownNow();
            serverSocket.close();
            log.info("Server stopped");
        } catch (IOException e) {
            log.error(e);
        }
    }


    private class ClientHandler implements Runnable {
        private final String name;
        private final Socket socket;

        public ClientHandler(String name, Socket socket) {
            this.name = name;
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    var writer = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(line.trim())) {
                        writer.println("qq");
                        break;
                    }
                    writer.println("[ECHO] " + line);
                }
            } catch (IOException e) {
                log.error("Error " + name, e);
            } finally {
                cleanup();
            }

        }

        private void cleanup() {
            clients.remove(name);
            log.info("Client {} disconnected", name);
            try {
                if (!socket.isClosed()) socket.close();
            } catch (IOException ignored) {}
        }

    }
}



