package com.librarysystem.model;

public class Book {
    // Attributes
    private String isbn;
    private String title;
    private String author;
    private int yearPublished;
    private boolean borrowed;

    // Constructor
    public Book(String isbn, String title, String author, int yearPublished) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.borrowed = false;
    }

    // Constructor with only ISBN and title
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.author = ""; // default value for author
        this.yearPublished = 0; // default value for yearPublished
        this.borrowed = false;
    }

    // Getters and setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    // toString method to represent Book object as a string
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", borrowed=" + borrowed +
                '}';
    }
}
