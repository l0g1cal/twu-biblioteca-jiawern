package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.*;

public class CheckoutMovieOption implements Option {

    @Override
    public void run(Library library, Scanner scanner) {
        while (true) {
            BibliotecaApp.printToCommandLine("Select a movie that you would like to checkout ... Or type 'back' to go back to options");
            ArrayList<Movie> movies = library.getMovies();
            displayMovies(library, movies);
            String ipt = scanner.nextLine();
            boolean isCheckoutBook = checkoutMovie(library, movies, ipt);
            if (isCheckoutBook) break;
        }
    }

    private void displayMovies(Library library, ArrayList<Movie> movies) {
        String moviesString = library.pprint(movies);
        BibliotecaApp.printToCommandLine("Here is the list of movies in this Biblioteca");
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

        } catch (IndexOutOfBoundsException e) {
            BibliotecaApp.printToCommandLine(CHECKOUT_MOVIE_FAILURE_MESSAGE);
        }
        return false;
    }
}
