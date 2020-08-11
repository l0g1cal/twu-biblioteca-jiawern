package com.twu.biblioteca.option;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.User;

import java.util.Scanner;

import static com.twu.biblioteca.Constants.USER_INFO_LIST_MESSAGE;

public class ViewUserInfoOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        BibliotecaApp.printToCommandLine(USER_INFO_LIST_MESSAGE);
        User currentUser = BibliotecaApp.getCurrentUser();
        String infoString = currentUser.pprintUserInfo();
        BibliotecaApp.printToCommandLine(infoString);
    }
}
