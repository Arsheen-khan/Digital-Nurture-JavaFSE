package Q33_TransactionHandlingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionDemo {

    private static final String URL =
            "jdbc:mysql://localhost:3306/bankdb";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void transfer(
            int fromAccount,
            int toAccount,
            double amount) {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    URL, USERNAME, PASSWORD);

            // Disable auto commit
            con.setAutoCommit(false);

            // Debit Query
            String debitQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

            PreparedStatement debitStmt =
                    con.prepareStatement(debitQuery);

            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccount);

            int debitRows = debitStmt.executeUpdate();

            // Credit Query
            String creditQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

            PreparedStatement creditStmt =
                    con.prepareStatement(creditQuery);

            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccount);

            int creditRows = creditStmt.executeUpdate();

            // Commit transaction
            if (debitRows > 0 && creditRows > 0) {

                con.commit();

                System.out.println(
                        "Transaction Successful. Amount Transferred.");
            }
            else {

                con.rollback();

                System.out.println(
                        "Transaction Failed. Rolled Back.");
            }

            debitStmt.close();
            creditStmt.close();
            con.close();

        } catch (Exception e) {

            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println(
                    "Transaction Failed. Rolled Back.");

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        transfer(101, 102, 2000);
    }
}