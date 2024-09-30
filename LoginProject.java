/*/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/

package com.mycompany.logininpoe;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 *
 * @author RC_Student_lab
 */
public class LoginProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // User registration
        System.out.println("Please enter the following details to register:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        
        // Register user
        String registrationMessage = Login.registerUser(username, password, firstName, lastName);
        System.out.println(registrationMessage);
        
        if (registrationMessage.startsWith("User registered successfully")) {
            // User login
            System.out.println("Please enter your details to login:");
            System.out.print("Username: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Password: ");
            String loginPassword = scanner.nextLine();
            
            boolean loginSuccess = Login.loginUser(loginUsername, loginPassword, username, password);
            String loginStatus = Login.returnLoginStatus(loginSuccess, firstName, lastName);
            System.out.println(loginStatus);
        }
        
    }
    /**
     *
     * @param username
     * @return
     */
    public static boolean checkUserName(String username){
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
  



