package Q20_TryCatchExample;

import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int a = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int b = scanner.nextInt();
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Cannot divide by zero.");
        }
        scanner.close();
    }
}
