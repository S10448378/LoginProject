/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logininpoe;

import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
     public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password meets the complexity requirements
    public static boolean checkPasswordComplexity(String password) {
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        boolean hasSpecialChar = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasMinLength = password.length() >= 8;

        return hasUpperCase && hasLowerCase && hasSpecialChar && hasNumber && hasMinLength;
    }

    // Method to register a user with input validation
    public static String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }

        return "User registered successfully: " + firstName + " " + lastName;
    }

    // Method to login a user, checking username and password
    public static boolean loginUser(String enteredUsername, String enteredPassword, String storedUsername, String storedPassword) {
        return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);
    }

    // Method to return login status message
    public static String returnLoginStatus(boolean loginSuccess, String firstName, String lastName) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    
}

