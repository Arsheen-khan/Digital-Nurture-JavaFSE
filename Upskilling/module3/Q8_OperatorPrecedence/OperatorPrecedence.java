package Q8_OperatorPrecedence;

public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Result: " + result);
        System.out.println("Explanation: multiplication is evaluated before addition, so 5 * 2 = 10, then 10 + 10 = 20.");
        int another = (10 + 5) * 2;
        System.out.println("Expression: (10 + 5) * 2");
        System.out.println("Result: " + another);
        System.out.println("Explanation: parentheses change the order so addition happens first.");
    }
}
