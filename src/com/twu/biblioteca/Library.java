package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();
    private ArrayList<Movie> movies;


    public Library(ArrayList<Book> books, ArrayList<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
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

    public String pprintBooks(ArrayList<Book> books) {
        String prettyBookList = "";
        int count = 0;
        for (Book book : books) {
            prettyBookList = prettyBookList + count + ") " + book.toString() + '\n';
            count++;
        }
        return prettyBookList;
    }

    public String pprintMovies(ArrayList<Movie> movies) {
        String prettyMovieList = "";
        int count = 0;
        for (Movie movie : movies) {
            prettyMovieList = prettyMovieList + count + ") " + movie.toString() + '\n';
            count++;
        }
        return prettyMovieList;
    }
}
