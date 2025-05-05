package org.lessons.lesson34;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerEntry {
    private static final int PORT = 1111;

    private final ExecutorService pool = Executors.newCachedThreadPool();
    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<String, ClientHandler> map = new HashMap<>();

    public static void main(String[] args) {

    }




}
