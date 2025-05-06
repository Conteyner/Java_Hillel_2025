package org.lessons.lesson34.Server;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class ServerEntry {
    private static final int PORT = 1111;

    public static void main(String[] args) {
        try {
            new Server(PORT).start();
        } catch (IOException e) {
            log.error("Failed to start the server", e);
        }
    }
}
