package com.twu.biblioteca.option;

import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.*;

public class ReturnBookOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        while (true) {
            User currentUser = BibliotecaApp.getCurrentUser();
            boolean isUserHasBorrowedBooks = checkUserHasBorrowedBooks(library, currentUser);
            if (!isUserHasBorrowedBooks) {
                BibliotecaApp.printToCommandLine(NO_BORROWED_BOOKS_MESSAGE);
                break;
            }
            BibliotecaApp.printToCommandLine(RETURN_BOOK_MESSAGE);
            ArrayList<Book> borrowedBooks = library.getBorrowedBooks(currentUser);
            displayBorrowedBooks(library, borrowedBooks);
            String ipt = scanner.nextLine();
            boolean isReturnBook = returnBook(library, borrowedBooks, ipt, currentUser);
            if (isReturnBook) break;
        }
    }

    private boolean checkUserHasBorrowedBooks(Library library, User user) {
        int numBorrowedBooks = library.totalBorrowedBooks(user);
        return numBorrowedBooks > 0;
    }

    private void displayBorrowedBooks(Library library, ArrayList<Book> borrowedBooks) {
        String borrowedBooksString = library.pprint(borrowedBooks);
        BibliotecaApp.printToCommandLine(borrowedBooksString);
    }

    private boolean returnBook(Library library, ArrayList<Book> borrowedBooks, String ipt, User currentUser) {
        if (ipt.equals("back")) {
            return true;
        }
        try {
            Book selectedBook = borrowedBooks.get(Integer.parseInt(ipt));
            boolean isReturn = library.returnBook(selectedBook, currentUser);
            if (isReturn) {
                BibliotecaApp.printToCommandLine(RETURN_BOOK_SUCCESS_MESSAGE);
                return true;
            } else {
                BibliotecaApp.printToCommandLine(RETURN_BOOK_FAILURE_MESSAGE);
            }
        } catch (Exception e) {
            BibliotecaApp.printToCommandLine(RETURN_BOOK_FAILURE_MESSAGE);
        }
        return false;
    }
}
