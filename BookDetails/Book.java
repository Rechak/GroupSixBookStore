package group6.bookstore.BookDetails;
import jakarta.persistence.*;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ISBN")
    private Long ISBN;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "bookDescription")
    private String bookDescription;

    @Column(name = "price")
    private Double price;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "yearPublished")
    private Integer yearPublished;

    @Column(name = "copiesSold")
    private Long copiesSold;

    public Book() {
    }

    public Book(Long ISBN, String bookName, String bookDescription, Double price, String author, String genre, String publisher, Integer yearPublished, Long copiesSold) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Long getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(Long copiesSold) {
        this.copiesSold = copiesSold;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "books{" +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearPublished=" + yearPublished +
                ", copiesSold=" + copiesSold +
                '}';
    }
}
