package com.workshop.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleLogicTest {

    Library library;
    ConsoleLogic consoleLogic;

    @BeforeEach
    void setUp() {
        library = new Library();
        consoleLogic = new ConsoleLogic(library);
    }

    @Test
    void shouldPrintCommand() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        consoleLogic.printOutput();
        String output = outputStream.toString();

        String expected = "cmd> ";

        assertEquals(expected, output);
    }

    @Test
    void shouldReturnFalse_whenQuitCommandEntered() {
        boolean actual = consoleLogic.checkMainCommand("quit");

        assertFalse(actual);
    }

    @Test
    void shouldAddBookAndPrintAddedMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        consoleLogic.checkLibraryCommand("add book1");

        assertTrue(outputStream.toString().contains("added"));
    }

    @Test
    void shouldPrintBookList() {
        library.addBook("book1");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        consoleLogic.checkLibraryCommand("list");

        assertTrue(outputStream.toString().contains("book1"));
    }

    @Test
    void shouldFindBookAndPrintResult(){
        library.addBook("book1");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        consoleLogic.checkLibraryCommand("find book1");

        assertTrue(outputStream.toString().contains("book1"));
    }

    @Test
    void shouldRemoveBookAndPrintRemoved(){
        library.addBook("book1");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        consoleLogic.checkLibraryCommand("remove book1");

        assertNull(library.getBook("book1"));
        assertTrue(outputStream.toString().contains("removed"));
    }

    @Test
    void shouldReturnTrue_whenMainCommandIsValid(){
        boolean excepted = true;

        boolean actual = consoleLogic.checkMainCommand("add ");

        assertEquals(excepted, actual);
    }

}