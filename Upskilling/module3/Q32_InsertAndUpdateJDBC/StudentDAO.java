package Q32_InsertAndUpdateJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // Insert Student
    public void insertStudent(int id, String name, int age) {

        String query =
                "INSERT INTO students(id, name, age) VALUES(?, ?, ?)";

        try {
            Connection con =
                    DriverManager.getConnection(
                            URL, USERNAME, PASSWORD);

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            int rows = ps.executeUpdate();

            System.out.println(
                    rows + " record inserted successfully.");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Student
    public void updateStudent(int id, String newName, int newAge) {

        String query =
                "UPDATE students SET name=?, age=? WHERE id=?";

        try {
            Connection con =
                    DriverManager.getConnection(
                            URL, USERNAME, PASSWORD);

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, newName);
            ps.setInt(2, newAge);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            System.out.println(
                    rows + " record updated successfully.");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}