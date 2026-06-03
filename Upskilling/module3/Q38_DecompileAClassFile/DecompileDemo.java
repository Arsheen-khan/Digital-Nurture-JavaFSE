package Q38_DecompileAClassFile;

public class DecompileDemo {

    public int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {

        DecompileDemo obj = new DecompileDemo();

        System.out.println("Square = " + obj.square(5));

    }
}