package org.lessons.lesson32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        if(book == null) {
            throw new NullPointerException("book is null");
        }
        if (!books.contains(book)) {
            books.add(book);
        }
    }
    public boolean removeBook(Book book) {
        if(book == null) {
            throw new NullPointerException("book is null");
        }
        return books.remove(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public int getBookCount(){
        return books.size();
    }


}
