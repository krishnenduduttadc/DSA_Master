package DP_SOLIDPattern;

//Subclass must replace parent safely.
//No unexpected behavior.
//Maintains correctness.
//Uses polymorphism.

class Bird {
    void fly() {
        System.out.println("Flying");
    }
}

class Sparrow extends Bird {
}

public class LSPDemo {
    public static void main(String[] args) {
        Bird b = new Sparrow();
        b.fly();
    }
}

