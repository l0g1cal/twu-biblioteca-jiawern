package com.twu.biblioteca.option;

import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.VIEW_BORROWED_BOOKS_MESSAGE;

public class ViewBorrowedBooksOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        Map<User, ArrayList<Book>> borrowedBooksMap = library.getBorrowedBooksMap();
        String booksString = printUserBorrowedBooks(library, borrowedBooksMap);
        BibliotecaApp.printToCommandLine(VIEW_BORROWED_BOOKS_MESSAGE);
        BibliotecaApp.printToCommandLine(booksString);
    }

    private String printUserBorrowedBooks(Library library, Map<User, ArrayList<Book>> borrowedBooksMap) {
        String prettyString = "";
        for (Map.Entry<User, ArrayList<Book>> entry : borrowedBooksMap.entrySet()) {
            User user = entry.getKey();
            ArrayList<Book> borrowedBooks = entry.getValue();
            prettyString = prettyString + "Details: " + user.pprintUserInfo();
            prettyString = prettyString + "Library Number: " + user.getLibraryNumber() + newLine();
            prettyString = prettyString + library.pprint(borrowedBooks) + newLine();
        }
        return prettyString;
    }

    private String newLine() {
        return  "\n";
    }
}
