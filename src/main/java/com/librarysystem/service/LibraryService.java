package com.librarysystem.service;

import com.librarysystem.model.Book;
import com.librarysystem.model.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books;
    private List<User> users;

    public LibraryService() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to find a book by its title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Method to find books by author
    public List<Book> findBooksByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    // Method to borrow a book
    public boolean borrowBook(Book book, User user) {
        if (books.contains(book) && !book.isBorrowed()) {
            book.setBorrowed(true);
            user.borrowBook(book);
            return true; // Successfully borrowed
        } else {
            return false; // Book not available
        }
    }

    // Method to return a book
    public void returnBook(Book book, User user) {
        if (user.getBooks().contains(book)) {
            book.setBorrowed(false);
            user.returnBook(book);
        }
    }

    // Method to add a user to the library
    public void addUser(User user) {
        users.add(user);
    }

    // Method to remove a user from the library
    public void removeUser(User user) {
        users.remove(user);
    }

    // Method to get all books in the library
    public List<Book> getAllBooks() {
        return books;
    }

    // Method to get all users in the library
    public List<User> getAllUsers() {
        return users;
    }
}
