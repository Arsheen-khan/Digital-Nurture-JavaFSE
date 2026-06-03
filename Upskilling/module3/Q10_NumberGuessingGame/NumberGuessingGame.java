package Q10_NumberGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess a number between 1 and 100.");
        while (true) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            if (guess < target) {
                System.out.println("Too low. Try again.");
            } else if (guess > target) {
                System.out.println("Too high. Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number.");
                break;
            }
        }
        scanner.close();
    }
}
