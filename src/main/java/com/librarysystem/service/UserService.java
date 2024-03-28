package com.librarysystem.service;

import com.librarysystem.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    // Declare the 'users' list at the class level
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    // Method to add a user
    public void addUser(User user) {
        users.add(user);
    }

    // Method to remove a user
    public void removeUser(User user) {
        users.remove(user);
    }

    // Method to find a user by their ID
    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null; // User not found
    }

    // Method to find users by their name
    public List<User> findUsersByName(String name) {
        List<User> foundUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getName().equals(name)) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }

    // Method to get all users
    public List<User> getAllUsers() {
        return users;
    }
}
