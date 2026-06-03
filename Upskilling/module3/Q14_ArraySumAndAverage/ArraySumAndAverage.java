package Q14_ArraySumAndAverage;

import java.util.Scanner;

public class ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a positive number of elements.");
            scanner.close();
            return;
        }
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            elements[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int value : elements) {
            sum += value;
        }
        double average = (double) sum / n;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        scanner.close();
    }
}
