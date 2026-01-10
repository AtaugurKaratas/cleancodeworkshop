package com.workshop.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleLogic {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private final Library library;

    public ConsoleLogic(Library library) {
        this.library = library;
    }

    public void printOutput() {
        System.out.print(ConsoleCommands.CMD.command);
    }

    public boolean writeInput() throws IOException {
        String line = in.readLine();
        return checkMainCommand(line);
    }

    public boolean checkMainCommand(String command) {
        if (command == null || command.equals("quit")) return false;

        if (checkCommand(command))
            checkLibraryCommand(command);
        else
            return false;

        return true;
    }

    public void checkLibraryCommand(String command) {
        if (command.startsWith(ConsoleCommands.ADD.command)) {
            library.addBook(command.substring(4));
            System.out.println("added");
        } else if (command.startsWith(ConsoleCommands.LIST.command))
            printLibraryList();
        else if (command.startsWith(ConsoleCommands.FIND.command))
            System.out.println(library.getBook(command.substring(5)));
        else if (command.startsWith(ConsoleCommands.REMOVE.command)) {
            library.removeBook(command.substring(7));
            System.out.println("removed");
        }
    }

    public boolean checkCommand(String command) {
        boolean check = false;
        ConsoleCommands[] consoleCommandsList = ConsoleCommands.values();
        for (ConsoleCommands consoleCommand : consoleCommandsList) {
            if (command.startsWith(consoleCommand.command)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void printLibraryList() {
        library.getBookList().forEach(System.out::println);
    }
}
