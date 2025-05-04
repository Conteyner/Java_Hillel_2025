package org.lessons;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.lessons.lesson32.Book;
import org.lessons.lesson32.Library;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {
    private Library lib;

    @Before
    public void setUp() {
        lib = new Library();
    }

    @Test
    public void testAddBook(){
        Book book = new Book("Il Principe","Niccolò di Bernardo dei Machiavelli");
        lib.addBook(book);

        assertEquals(1, lib.getBooks().size());
        assertTrue(lib.getBooks().contains(book));
    }

    @Test
    public void testRemoveBook() {
        Book book = new Book("Il Principe","Niccolò di Bernardo dei Machiavelli");
        lib.addBook(book);
        boolean removed = lib.removeBook(book);

        assertTrue(removed);
        assertEquals(0, lib.getBookCount());
    }

    @Test
    public void testGetBooks() {
        Book book = new Book("Il Principe","Niccolò di Bernardo dei Machiavelli");
        lib.addBook(book);
        List<Book> books = lib.getBooks();

        assertEquals(1, books.size());
        assertTrue(books.contains(book));

    }

    @Test
    public void testGetBookCount() {
        assertEquals(0, lib.getBookCount());
    }


}
