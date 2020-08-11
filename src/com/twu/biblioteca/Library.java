package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private ArrayList<Book> books;
    private Map<User, ArrayList<Book>> borrowedBooksMap = new HashMap();
    private ArrayList<Movie> movies;
    private ArrayList<Movie> borrowedMovies = new ArrayList<Movie>();


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

    public ArrayList<Book> getBorrowedBooks(User user) {
        ArrayList<Book> borrowedBooks = borrowedBooksMap.get(user);
        return borrowedBooks;
    }

    public int totalBooksInLibrary() {
        return books.size();
    }

    public int totalBorrowedBooks(User user) {
        if (borrowedBooksMap.containsKey(user)) {
            ArrayList<Book> borrowedBooks = borrowedBooksMap.get(user);
            return borrowedBooks.size();
        }
        return 0;
    }

    public boolean checkoutBook(Book book, User user) {
        if (!borrowedBooksMap.containsKey(user)) {
            borrowedBooksMap.put(user, new ArrayList<Book>());
        }
        for (Book b : books) {
            if (b.equals(book)) {
                books.remove(b);
                borrowedBooksMap.get(user).add(b);
                return true;
            }
        }
        return false;
    }

    public boolean checkoutMovie(Movie movie) {
        for (Movie m : movies) {
            if (m.equals(movie)) {
                movies.remove(m);
                borrowedMovies.add(m);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(Book book, User user) {
        ArrayList<Book> borrowedBooks = borrowedBooksMap.get(user);
        for (Book b : borrowedBooks) {
            if (b.equals(book)) {
                borrowedBooks.remove(b);
                books.add(b);
                return true;
            }
        }
        return false;
    }

    public String pprint(Iterable<?> items) {
        String prettyList = "";
        int count = 0;
        for (Object item : items) {
            prettyList = prettyList + count + ") " + item.toString() + '\n';
            count++;
        }
        return prettyList;
    }
}
