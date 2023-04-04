package com.example.floatproject.user;

import com.example.floatproject.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Wishlist {

    private final int id;
    private final String name;
    private final List<Integer> bookIds;

    // New wishlist constructor
    public Wishlist(int id, String name) {
        this.name = name;
        this.id = id;
        this.bookIds = new ArrayList<>();
    }

    // Existing wishlist constructor
    public Wishlist(int id, String name, List<Integer> bookIds) {
        this.name = name;
        this.id = id;
        this.bookIds = bookIds;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void addBook(Book book) {
        this.bookIds.add(book.getId());
    }

    public void addBook(Integer bookId) {
        this.bookIds.add(bookId);
    }

    public void removeBook(Book book) {
        this.bookIds.remove(book.getId());
    }

    public void removeBook(int bookId) {
        this.bookIds.remove(bookId);
    }

    public List<Integer> getBookIds() {
        return this.bookIds;
    }

    public String pack() {
        return this.bookIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public static List<Integer> unpack(String packedBookIds) {
        List<Integer> wishlists = new ArrayList<>();
        if (packedBookIds.isEmpty()) {
            return wishlists;
        }

        for (String id : packedBookIds.split(",")) {
            wishlists.add(Integer.parseInt(id));
        }
        return wishlists;
    }

}
