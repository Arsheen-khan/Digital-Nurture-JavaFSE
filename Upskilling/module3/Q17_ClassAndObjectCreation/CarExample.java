package Q17_ClassAndObjectCreation;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2023);
        Car car2 = new Car("Honda", "Civic", 2022);
        car1.displayDetails();
        car2.displayDetails();
    }
}

class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayDetails() {
        System.out.println("Car: " + year + " " + make + " " + model);
    }
}
