package com.example.floatproject.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private final int id;
    private final List<Integer> wishlistIds;

    // New user constructor
    public User(int id) {
        this.id = id;
        this.wishlistIds = new ArrayList<>();
    }

    // Existing user constructor
    public User(int id, List<Integer> wishlistIds) {
        this.id = id;
        this.wishlistIds = wishlistIds;
    }

    public int getId() {
        return this.id;
    }

    public List<Integer> getWishlistIds() {
        return this.wishlistIds;
    }

    public String packWishlists() {
        return this.wishlistIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public static List<Integer> unpackWishlists(String packedWishlists) {
        List<Integer> wishlists = new ArrayList<>();
        if (packedWishlists.isEmpty()) {
            return wishlists;
        }

        for (String id : packedWishlists.split(",")) {
            wishlists.add(Integer.parseInt(id));
        }
        return wishlists;
    }

}
