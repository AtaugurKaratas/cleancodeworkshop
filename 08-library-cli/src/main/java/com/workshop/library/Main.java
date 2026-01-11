package com.workshop.library;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Library library = new Library();
        ConsoleLogic consoleLogic = new ConsoleLogic(library);
        boolean check = true;
        while (check) {
            consoleLogic.printOutput();
            check = consoleLogic.writeInput();
        }
    }
}
