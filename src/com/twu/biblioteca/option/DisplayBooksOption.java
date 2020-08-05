package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;

import java.util.ArrayList;
import java.util.Scanner;

public class DisplayBooksOption implements Option {

    @Override
    public void run(Library library, Scanner scanner) {
        ArrayList<Book> books = library.getBooks();
        String booksString = library.pprintBooks(books);
        BibliotecaApp.printToCommandLine("Here is the list of books in this Biblioteca");
        BibliotecaApp.printToCommandLine(booksString);
    }
}
