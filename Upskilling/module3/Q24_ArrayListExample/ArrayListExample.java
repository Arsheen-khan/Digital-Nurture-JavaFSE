package Q24_ArrayListExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        System.out.println("Enter student names (blank line to stop):");
        while (true) {
            String name = scanner.nextLine();
            if (name.isBlank()) {
                break;
            }
            names.add(name);
        }
        System.out.println("Names entered:");
        for (String studentName : names) {
            System.out.println(studentName);
        }
        scanner.close();
    }
}
