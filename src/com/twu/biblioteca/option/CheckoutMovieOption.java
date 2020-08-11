package com.twu.biblioteca.option;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.*;

public class CheckoutMovieOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        while (true) {
            BibliotecaApp.printToCommandLine(SELECT_MOVIE_MESSAGE);
            ArrayList<Movie> movies = library.getMovies();
            displayMovies(library, movies);
            String ipt = scanner.nextLine();
            boolean isCheckoutBook = checkoutMovie(library, movies, ipt);
            if (isCheckoutBook) break;
        }
    }

    private void displayMovies(Library library, ArrayList<Movie> movies) {
        String moviesString = library.pprint(movies);
        BibliotecaApp.printToCommandLine(MOVIE_LIST_MESSAGE);
        BibliotecaApp.printToCommandLine(moviesString);
    }

    private boolean checkoutMovie(Library library, ArrayList<Movie> movies, String ipt) {
        if (ipt.equals("back")) {
            return true;
        }
        try {
            Movie selectedMovie = movies.get(Integer.parseInt(ipt));
            boolean isCheckout = library.checkoutMovie(selectedMovie);
            if (isCheckout) {
                BibliotecaApp.printToCommandLine(CHECKOUT_MOVIE_SUCCESS_MESSAGE);
                return true;
            } else {
                BibliotecaApp.printToCommandLine(CHECKOUT_MOVIE_FAILURE_MESSAGE);
            }
        } catch (Exception e) {
            BibliotecaApp.printToCommandLine(CHECKOUT_MOVIE_FAILURE_MESSAGE);
        }
        return false;
    }
}
