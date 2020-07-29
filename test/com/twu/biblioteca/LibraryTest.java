package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private ArrayList<Book> books = new ArrayList<Book>();
    private Library library;

    @Before
    public void setUp() {
        Book book1 = new Book("title1", "author1", "2020");
        books.add(book1);
        library = new Library(books);
    }

    @Test
    public void shouldCheckoutBookIfAvailable() {
        assertEquals(1, library.totalBooksInLibrary());
        Book bookToCheckout = books.get(0);
        boolean output = library.checkoutBook(bookToCheckout);
        assertEquals(true, output);
        assertEquals(0, library.totalBooksInLibrary());
    }
}
