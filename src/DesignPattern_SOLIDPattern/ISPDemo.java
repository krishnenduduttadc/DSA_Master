package DesignPattern_SOLIDPattern;

//
//Many small interfaces.
//Avoid fat interfaces.
//Client uses only needed methods.
//Improves flexibility.

interface Printer {
    void print();
}

class HP implements Printer {
    public void print() {
        System.out.println("Print");
    }
}

public class ISPDemo {
    public static void main(String[] args) {
        new HP().print();
    }
}

