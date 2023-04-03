/*
 * This is the book class that uses the GeekText db on postgres.
 */
package com.example.geektext.book;

// Import everything
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // Maps to book table
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publishing_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishing_date;
    @Column(name = "publisher")
    private String publisher = "";
    @Column(name = "genre")
    private String genre;
    @Column(name = "copies_sold")
    private int copies_sold;
    @Column(name = "rating")
    private double rating;

    public Book() {}

    public Book(String title,
                String author,
                String genre,
                int copies_sold,
                double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.copies_sold = copies_sold;
        this.rating = rating;
    }

    public Book(String title,
                String author,
                String genre,
                int copies_sold,
                double rating,
                LocalDate publishing_date,
                String publisher) {
        this(title, author, genre, copies_sold, rating);
        this.publishing_date = publishing_date;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishing_date() {
        return publishing_date;
    }

    public void setPublishing_date(LocalDate publishing_date) {
        this.publishing_date = publishing_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopies_sold() {
        return copies_sold;
    }

    public void setCopies_sold(int copies_sold) {
        this.copies_sold = copies_sold;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "Book {\n" +
                "id=" + id +
                "\ntitle='" + title + "\'" +
                "\nauthor='" + author + "\'" +
                "\ngenre='" + genre + "\'" +
                "\ncopies_sold=" + copies_sold +
                "\nrating=" + rating +
                "\npublisher=" + publisher +
                "\npublishing_date=" + publishing_date +
                "\n}";
    }

}
