package com.librarysystem;

import com.librarysystem.model.Book;
import com.librarysystem.model.User;
import com.librarysystem.service.LibraryService;
import com.librarysystem.service.UserService;

public class Main {
    public static void main(String[] args) {
        // Create some sample books
        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Data Structures and Algorithms", "Jane Smith");

        // Create some sample users
        User user1 = new User(1, "Alice", "alice@example.com", "123456789");
        User user2 = new User(2, "Bob", "bob@example.com", "987654321");

        // Create instances of LibraryService and UserService
        LibraryService libraryService = new LibraryService();
        UserService userService = new UserService();

        // Add books to the library
        libraryService.addBook(book1);
        libraryService.addBook(book2);

        // Add users to the library
        userService.addUser(user1);
        userService.addUser(user2);

        // Borrow a book
        boolean bookBorrowed = libraryService.borrowBook(book1, user1);
        if (bookBorrowed) {
            System.out.println("Book borrowed successfully by " + user1.getName());
        } else {
            System.out.println("Book not available for borrowing");
        }

        // Return a book
        libraryService.returnBook(book1, user1);
        System.out.println("Book returned by " + user1.getName());

        // Find a book by title
        Book foundBook = libraryService.findBookByTitle("Java Programming");
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook.getTitle());
        } else {
            System.out.println("Book not found");
        }

        // Find users by name
        System.out.println("Users named Alice:");
        for (User user : userService.findUsersByName("Alice")) {
            System.out.println(user.getName());
        }
    }
}
