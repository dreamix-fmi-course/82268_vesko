package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Book
{
    private String ISBN;
    private String title;
    private String author;
    private BigDecimal price;
    private String publisher;
    private LocalDate publishedYear;

    public Book(String ISBN, String title, String author, BigDecimal price, String publisher, LocalDate publishedYear)
    {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public String getAuthor()
    {
        return author;
    }

    public LocalDate getPublishedYear()
    {
        return publishedYear;
    }

    public String getPublisher()
    {
        return publisher;
    }
}


