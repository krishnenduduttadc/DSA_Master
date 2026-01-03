package DP_CreationalPattern;


//Creates objects without exposing logic.
//Uses common interface.
//Centralizes object creation.
//Simplifies code.


interface Car {
    void drive();
}

class BMW implements Car {
    public void drive() {
        System.out.println("BMW");
    }
}

class CarFactory {
    static Car getCar() {
        return new BMW();
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        CarFactory.getCar().drive();
    }
}

