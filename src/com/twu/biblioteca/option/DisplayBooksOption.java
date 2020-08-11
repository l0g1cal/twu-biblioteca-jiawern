package com.twu.biblioteca.option;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.BOOK_LIST_MESSAGE;

public class DisplayBooksOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        ArrayList<Book> books = library.getBooks();
        String booksString = library.pprint(books);
        BibliotecaApp.printToCommandLine(BOOK_LIST_MESSAGE);
        BibliotecaApp.printToCommandLine(booksString);
    }
}
