package Q22_FileWriting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileWritingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to write to output.txt: ");
        String input = scanner.nextLine();
        try {
            Path filePath = Path.of("output.txt");
            Files.writeString(filePath, input + System.lineSeparator());
            System.out.println("Data written to " + filePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to write file: " + e.getMessage());
        }
        scanner.close();
    }
}
