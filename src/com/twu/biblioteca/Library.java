package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;;
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public int totalBooksInLibrary() {
        return books.size();
    }

    public int totalBorrowedBooks() {
        return borrowedBooks.size();
    }

    public boolean checkoutBook(Book book) {
        for (Book b : books) {
            if (b.equals(book)) {
                books.remove(b);
                borrowedBooks.add(b);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(Book book) {
        for (Book b : borrowedBooks) {
            if (b.equals(book)) {
                borrowedBooks.remove(b);
                books.add(b);
                return true;
            }
        }
        return false;
    }

    public String pprintBooks() {
        String prettyBookList = "";
        int count = 0;
        for (Book book : books) {
            prettyBookList = prettyBookList + count + ") " + book.toString() + '\n';
            count++;
        }
        return prettyBookList;
    }
}
