package com.workshop.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<String> bookList = new ArrayList<>();

    public void addBook(String book) {
        bookList.add(book);
    }

    public List<String> getBookList() {
        return bookList;
    }

    public String getBook(String book) {
        return bookList.contains(book) ? book : null;
    }

    public void removeBook(String book) {
        bookList.remove(book);
    }

}
