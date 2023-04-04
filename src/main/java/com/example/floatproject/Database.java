package com.example.floatproject;

import com.example.floatproject.user.User;
import com.example.floatproject.user.Wishlist;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private final String url;
    private Connection connection;

    public Database(String name) {
        this.url = "jdbc:sqlite:" + new File(name + ".db").getAbsolutePath();
    }

    public void connect() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            this.createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        try {
            this.connection.createStatement().execute("""
                CREATE TABLE IF NOT EXISTS users (
                	id integer PRIMARY KEY,
                	wishlists text NOT NULL
                );""");

            this.connection.createStatement().execute("""
                CREATE TABLE IF NOT EXISTS wishlists (
                    id integer PRIMARY KEY,
                    name text NOT NULL,
                    bookIds text NOT NULL
                );""");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("""
                INSERT INTO users (id, wishlists)
                VALUES (?, ?);""");

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.packWishlists());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(User user) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("""
                UPDATE users
                SET wishlists = ?
                WHERE id = ?;""");

            preparedStatement.setString(1, user.packWishlists());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(int id) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("""
                SELECT * FROM users
                WHERE id = ?
                LIMIT 1;""");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        id,
                        User.unpackWishlists(resultSet.getString("wishlists"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addWishlist(Wishlist wishlist) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("""
                INSERT INTO wishlists (id, name, bookIds)
                VALUES (?, ?, ?);""");

            preparedStatement.setInt(1, wishlist.getId());
            preparedStatement.setString(2, wishlist.getName());
            preparedStatement.setString(3, wishlist.pack());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveWishlist(Wishlist wishlist) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("""
                UPDATE wishlists
                SET bookIds = ?
                WHERE id = ?;""");

            preparedStatement.setString(1, wishlist.pack());
            preparedStatement.setInt(2, wishlist.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Wishlist getWishlist(int id) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("""
                SELECT * FROM wishlists
                WHERE id = ?
                LIMIT 1;""");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Wishlist(
                        id,
                        resultSet.getString("name"),
                        Wishlist.unpack(resultSet.getString("bookIds"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get the next available id
     * @return the next available id
     */
    public int getNextId(String table) {
        try {
            ResultSet resultSet = this.connection.createStatement()
                    .executeQuery("SELECT id FROM " + table + " ORDER BY id DESC LIMIT 1;");

            if (resultSet.next()) {
                return resultSet.getInt("id") + 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
