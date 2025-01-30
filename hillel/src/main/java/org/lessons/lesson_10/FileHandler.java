package org.lessons.lesson_10;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private final static String BASE_PATH = "files/";

        public String writeFile(String fileName, String fileContent) {
            File dir = new File(BASE_PATH);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, fileName + ".txt");

            try (FileWriter fw = new FileWriter(file)) {
            fw.write(fileContent);
            return "Success.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            int sym;
            StringBuilder sb = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                sb.append((char) sym);
            }
            return sb.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
