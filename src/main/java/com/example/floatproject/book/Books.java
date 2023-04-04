package com.example.floatproject.book;

import java.util.List;

public class Books {

    private final List<Integer> books;

    public Books(List<Integer> books) {
        this.books = books;
    }

    public List<Integer> getBookIds() {
        return this.books;
    }
}
