package com.librarysystem.service;

import com.librarysystem.model.Book;
import com.librarysystem.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryServiceTest {
    private LibraryService libraryService;
    private Book book;
    private User user;

    @Before
    public void setUp() {
        libraryService = new LibraryService();
        book = new Book("Java Programming", "John Doe");
        user = new User(1, "Alice", "alice@example.com", "123456789");
    }

    @Test
    public void testAddBook() {
        libraryService.addBook(book);
        assertEquals(1, libraryService.getAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        libraryService.addBook(book);
        libraryService.removeBook(book);
        assertEquals(0, libraryService.getAllBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        libraryService.addBook(book);
        assertEquals(book, libraryService.findBookByTitle("Java Programming"));
    }

    @Test
    public void testFindBooksByAuthor() {
        libraryService.addBook(book);
        assertEquals(1, libraryService.findBooksByAuthor("John Doe").size());
    }

    @Test
    public void testBorrowBook() {
        libraryService.addBook(book);
        assertTrue(libraryService.borrowBook(book, user));
        assertTrue(book.isBorrowed());
        assertTrue(user.getBooks().contains(book));
    }

    @Test
    public void testReturnBook() {
        libraryService.addBook(book);
        libraryService.borrowBook(book, user);
        libraryService.returnBook(book, user);
        assertFalse(book.isBorrowed());
        assertFalse(user.getBooks().contains(book));
    }
}
