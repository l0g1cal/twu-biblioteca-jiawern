package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.RETURN_BOOK_FAILURE_MESSAGE;
import static com.twu.biblioteca.Constants.RETURN_BOOK_SUCCESS_MESSAGE;

public class ReturnBookOption implements Option {

    @Override
    public void run(Library library, Scanner scanner) {
        while (true) {
            BibliotecaApp.printToCommandLine("Select a book that you would like to return ... Or type 'back' to go back to options");
            ArrayList<Book> borrowedBooks = library.getBorrowedBooks();
            displayBorrowedBooks(library, borrowedBooks);
            String ipt = scanner.nextLine();
            boolean isReturnBook = returnBook(library, borrowedBooks, ipt);
            if (isReturnBook) break;
        }

    }

    private void displayBorrowedBooks(Library library, ArrayList<Book> borrowedBooks) {
        String borrowedBooksString = library.pprint(borrowedBooks);
        BibliotecaApp.printToCommandLine(borrowedBooksString);
    }

    private boolean returnBook(Library library, ArrayList<Book> borrowedBooks, String ipt) {
        if (ipt.equals("back")) {
            return true;
        }
        try {
            Book selectedBook = borrowedBooks.get(Integer.parseInt(ipt));
            boolean isReturn = library.returnBook(selectedBook);
            if (isReturn) {
                BibliotecaApp.printToCommandLine(RETURN_BOOK_SUCCESS_MESSAGE);
                return true;
            } else {
                BibliotecaApp.printToCommandLine(RETURN_BOOK_FAILURE_MESSAGE);
            }

        } catch (IndexOutOfBoundsException e) {
            BibliotecaApp.printToCommandLine(RETURN_BOOK_FAILURE_MESSAGE);
        }
        return false;
    }
}
