package Q25_HashMapExample;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> students = new HashMap<>();
        System.out.print("How many entries would you like to add? ");
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            students.put(id, name);
        }
        System.out.print("Enter an ID to retrieve: ");
        int lookupId = scanner.nextInt();
        String foundName = students.get(lookupId);
        if (foundName != null) {
            System.out.println("Student name: " + foundName);
        } else {
            System.out.println("Student ID not found.");
        }
        scanner.close();
    }
}
