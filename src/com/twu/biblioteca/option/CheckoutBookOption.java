package com.twu.biblioteca.option;

import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.*;

public class CheckoutBookOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        while (true) {
            BibliotecaApp.printToCommandLine(SELECT_BOOK_MESSAGE);
            User currentUser = BibliotecaApp.getCurrentUser();
            ArrayList<Book> books = library.getBooks();
            displayBooks(library, books);
            String ipt = scanner.nextLine();
            boolean isCheckoutBook = checkoutBook(library, books, ipt, currentUser);
            if (isCheckoutBook) break;
        }
    }

    private void displayBooks(Library library, ArrayList<Book> books) {
        String booksString = library.pprint(books);
        BibliotecaApp.printToCommandLine(BOOK_LIST_MESSAGE);
        BibliotecaApp.printToCommandLine(booksString);
    }

    private boolean checkoutBook(Library library, ArrayList<Book> books, String ipt, User currentUser) {
        if (ipt.equals("back")) {
            return true;
        }
        try {
            Book selectedBook = books.get(Integer.parseInt(ipt));
            boolean isCheckout = library.checkoutBook(selectedBook, currentUser);
            if (isCheckout) {
                BibliotecaApp.printToCommandLine(CHECKOUT_BOOK_SUCCESS_MESSAGE);
                return true;
            } else {
                BibliotecaApp.printToCommandLine(CHECKOUT_BOOK_FAILURE_MESSAGE);
            }
        } catch (Exception e) {
            BibliotecaApp.printToCommandLine(CHECKOUT_BOOK_FAILURE_MESSAGE);
        }
        return false;
    }
}
