package com.librarysystem;

import com.librarysystem.model.Book;
import com.librarysystem.model.User;
import com.librarysystem.service.LibraryService;
import com.librarysystem.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryService libraryService = new LibraryService();
        UserService userService = new UserService();

        int choice;
        do {
            System.out.println("\n\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Find Book by Title");
            System.out.println("6. Find Users by Name");
            System.out.println("7. Show All Books");
            System.out.println("8. Show All Users");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook(libraryService, scanner);
                    break;
                case 2:
                    addUser(userService, scanner);
                    break;
                case 3:
                    borrowBook(libraryService, userService, scanner);
                    break;
                case 4:
                    returnBook(libraryService, userService, scanner);
                    break;
                case 5:
                    findBookByTitle(libraryService, scanner);
                    break;
                case 6:
                    findUsersByName(userService, scanner);
                    break;
                case 7:
                    showAllBooks(libraryService);
                    break;
                case 8:
                    showAllUsers(userService);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addBook(LibraryService libraryService, Scanner scanner) {
        System.out.print("\nEnter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Year Published: ");
        int yearPublished = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        Book book = new Book(isbn, title, author, yearPublished);
        libraryService.addBook(book);
        System.out.println("Book added successfully.\n");
    }

    private static void addUser(UserService userService, Scanner scanner) {
        System.out.print("\nEnter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        User user = new User(id, name, email, phoneNumber);
        userService.addUser(user);
        System.out.println("User added successfully.\n");
    }

    private static void borrowBook(LibraryService libraryService, UserService userService, Scanner scanner) {
        System.out.print("\nEnter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        User user = userService.findUserById(userId);
        Book book = libraryService.findBookByTitle(bookTitle);

        if (user != null && book != null) {
            boolean success = libraryService.borrowBook(book, user);
            if (success) {
                System.out.println("Book borrowed successfully by " + user.getName());
                System.out.println();
            } else {
                System.out.println("Book not available for borrowing\n");
            }
        } else {
            System.out.println("User or book not found\n");
        }
    }

    private static void returnBook(LibraryService libraryService, UserService userService, Scanner scanner) {
        System.out.print("\nEnter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        User user = userService.findUserById(userId);
        Book book = libraryService.findBookByTitle(bookTitle);

        if (user != null && book != null) {
            libraryService.returnBook(book, user);
            System.out.println("Book returned by " + user.getName());
            System.out.println();
        } else {
            System.out.println("User or book not found\n");
        }
    }

    private static void findBookByTitle(LibraryService libraryService, Scanner scanner) {
        System.out.print("\nEnter title to search: ");
        String title = scanner.nextLine();
        Book foundBook = libraryService.findBookByTitle(title);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook.getTitle());
            System.out.println();
        } else {
            System.out.println("Book not found\n");
        }
    }

    private static void findUsersByName(UserService userService, Scanner scanner) {
        System.out.print("\nEnter name to search: ");
        String name = scanner.nextLine();
        System.out.println("Users named " + name + ":");
        for (User user : userService.findUsersByName(name)) {
            System.out.println(user.getName());
        }
        System.out.println();
    }

    private static void showAllBooks(LibraryService libraryService) {
        System.out.println("\nAll Books:");
        for (Book book : libraryService.getAllBooks()) {
            System.out.println(book);
        }
        System.out.println();
    }

    private static void showAllUsers(UserService userService) {
        System.out.println("\nAll Users:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
        System.out.println();
    }
}
