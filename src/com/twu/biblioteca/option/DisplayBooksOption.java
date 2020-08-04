package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;

import java.util.ArrayList;

public class DisplayBooksOption implements Option {

    @Override
    public void run() {
        Library library = BibliotecaApp.getLibrary();
        ArrayList<Book> books = library.getBooks();
        String booksString = library.pprintBooks(books);
        BibliotecaApp.printToCommandLine("Here is the list of books in this Biblioteca");
        BibliotecaApp.printToCommandLine(booksString);
    }
}
