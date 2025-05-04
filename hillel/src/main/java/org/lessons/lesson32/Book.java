package org.lessons.lesson32;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

}
