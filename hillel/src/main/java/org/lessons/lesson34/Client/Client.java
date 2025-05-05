package org.lessons.lesson34.Client;

import lombok.extern.log4j.Log4j2;
import org.lessons.lesson34.Server.Server;

import java.io.IOException;

@Log4j2
public class Client implements Runnable {
    private final String name;
    private final Server server;

    public Client(String name, Server server) throws IOException {
        this.name = name;
        this.server = server;
    }


    @Override
    public void run() {
        
    }
}
