package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.CHECKOUT_BOOK_FAILURE_MESSAGE;
import static com.twu.biblioteca.Constants.CHECKOUT_BOOK_SUCCESS_MESSAGE;

public class CheckoutBookOption implements Option {

    @Override
    public void run(Library library, Scanner scanner) {
        while (true) {
            BibliotecaApp.printToCommandLine("Select a book that you would like to checkout ... Or type 'back' to go back to options");
            ArrayList<Book> books = library.getBooks();
            displayBooks(library, books);
            String ipt = scanner.nextLine();
            boolean isCheckoutBook = checkoutBook(library, books, ipt);
            if (isCheckoutBook) break;
        }
    }

    private void displayBooks(Library library, ArrayList<Book> books) {
        String booksString = library.pprintBooks(books);
        BibliotecaApp.printToCommandLine("Here is the list of books in this Biblioteca");
        BibliotecaApp.printToCommandLine(booksString);
    }

    private boolean checkoutBook(Library library, ArrayList<Book> books, String ipt) {
        if (ipt.equals("back")) {
            return true;
        }
        try {
            Book selectedBook = books.get(Integer.parseInt(ipt));
            boolean isCheckout = library.checkoutBook(selectedBook);
            if (isCheckout) {
                BibliotecaApp.printToCommandLine(CHECKOUT_BOOK_SUCCESS_MESSAGE);
                return true;
            } else {
                BibliotecaApp.printToCommandLine(CHECKOUT_BOOK_FAILURE_MESSAGE);
            }

        } catch (IndexOutOfBoundsException e) {
            BibliotecaApp.printToCommandLine(CHECKOUT_BOOK_FAILURE_MESSAGE);
        }
        return false;
    }
}