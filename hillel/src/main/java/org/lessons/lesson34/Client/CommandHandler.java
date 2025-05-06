package org.lessons.lesson34.Client;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommandHandler {
    public boolean handleCommand(String command, Client client) {
        if (command.trim().toLowerCase().equals("exit")) {
            log.info("Executing exit command");
            return false;
        } else {
            return true;
        }
    }
}
