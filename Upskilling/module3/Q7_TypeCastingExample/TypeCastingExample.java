package Q7_TypeCastingExample;

public class TypeCastingExample {
    public static void main(String[] args) {
        double originalDouble = 9.87;
        int castToInt = (int) originalDouble;
        System.out.println("Double value: " + originalDouble);
        System.out.println("After casting to int: " + castToInt);
        int originalInt = 42;
        double castToDouble = originalInt;
        System.out.println("Int value: " + originalInt);
        System.out.println("After casting to double: " + castToDouble);
    }
}
