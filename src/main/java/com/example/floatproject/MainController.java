package com.example.floatproject;

import com.example.floatproject.book.Books;
import com.example.floatproject.user.User;
import com.example.floatproject.user.Wishlist;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@SpringBootApplication
@RestController
public class MainController {

    private static Database database;

    static {
        MainController.database = new Database("testdb");
        try {
            MainController.database.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser() {
        int id = MainController.database.getNextId("users");
        if (id == -1) {
            return ResponseEntity.internalServerError().build();
        }

        User user = new User(id);
        MainController.database.addUser(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/createWishlist")
    public ResponseEntity<Void> createWishlist(
            @RequestParam(value = "wishlistName", defaultValue = "") String wishlistName,
            @RequestParam(value = "userId", defaultValue = "") String userIdString
    ) {
        if (wishlistName.isEmpty() || userIdString.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        int userId;
        try {
            userId = Integer.parseInt(userIdString);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        User user = MainController.database.getUser(userId);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        int wishlistId = MainController.database.getNextId("wishlists");
        if (wishlistId == -1) {
            return ResponseEntity.internalServerError().build();
        }

        Wishlist wishlist = new Wishlist(wishlistId, wishlistName);
        MainController.database.addWishlist(wishlist);

        user.getWishlistIds().add(wishlistId);
        MainController.database.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addBookToWishlist")
    public ResponseEntity<Void> addBookToWishList(
            @RequestParam(value = "bookId", defaultValue = "") String bookIdString,
            @RequestParam(value = "wishlistId", defaultValue = "") String wishlistIdString
    ) {
        if (bookIdString.isEmpty() || wishlistIdString.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        int bookId;
        int wishlistId;
        try {
            bookId = Integer.parseInt(bookIdString);
            wishlistId = Integer.parseInt(wishlistIdString);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        Wishlist wishlist = MainController.database.getWishlist(wishlistId);
        if (wishlist == null) {
            return ResponseEntity.badRequest().build();
        }

        wishlist.addBook(bookId);
        MainController.database.saveWishlist(wishlist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/pullBookFromWishlist")
    public ResponseEntity<Void> pullBookFromWishList(
            @RequestParam(value = "bookId", defaultValue = "") String bookIdString,
            @RequestParam(value = "wishlistId", defaultValue = "") String wishlistIdString
    ) {
        if (bookIdString.isEmpty() || wishlistIdString.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        int bookId;
        int wishlistId;
        try {
            bookId = Integer.parseInt(bookIdString);
            wishlistId = Integer.parseInt(wishlistIdString);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        Wishlist wishlist = MainController.database.getWishlist(wishlistId);
        if (wishlist == null) {
            return ResponseEntity.badRequest().build();
        }

        wishlist.removeBook(bookId);
        MainController.database.saveWishlist(wishlist);

        // TODO: You'd add it to their shopping cart here
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/wishlist")
    public ResponseEntity<Books> viewWishlist(
            @RequestParam(value = "wishlistId", defaultValue = "") String wishlistIdString
    ) {
        if (wishlistIdString.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        int wishlistId;
        try {
            wishlistId = Integer.parseInt(wishlistIdString);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        Wishlist wishlist = MainController.database.getWishlist(wishlistId);
        if (wishlist == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new Books(wishlist.getBookIds()));
    }

}
