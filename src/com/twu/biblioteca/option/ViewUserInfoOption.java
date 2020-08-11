package com.twu.biblioteca.option;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.User;

import java.util.Scanner;

public class ViewUserInfoOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        BibliotecaApp.printToCommandLine("Here is your information\n");
        User currentUser = BibliotecaApp.getCurrentUser();
        String infoString = currentUser.pprintUserInfo();
        BibliotecaApp.printToCommandLine(infoString);
    }
}
