package Q21_CustomException;

import java.util.Scanner;

public class CustomExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        try {
            validateAge(age);
            System.out.println("Age is valid.");
        } catch (InvalidAgeException ex) {
            System.out.println(ex.getMessage());
        }
        scanner.close();
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
