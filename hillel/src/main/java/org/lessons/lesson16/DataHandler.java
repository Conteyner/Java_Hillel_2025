package org.lessons.lesson16;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

    private final Map<Integer, String> map;

    public DataHandler() {
        this.map = new DataRepository().getData();
    }
    // Метод формує виведення нумерованого переліку імен
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        sb.append("\nALL NAMES:\n");
        map.forEach((id, name) ->
                sb.append(String.format("%d) %d, %s%n",
                        count.incrementAndGet(),id, name)
        ));
        return sb.toString();
    }

    // Метод формує виведення імені за певним id
    public String getById(int id) {
        if (map.containsKey(id)) {
            return "\\nNAME: id " + id + ", " +
                    map.get(id);
        } else return "No data!";
    }
}
