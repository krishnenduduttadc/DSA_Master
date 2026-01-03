package DP_StructuralPattern;


//Provides simple interface to complex system.
//Hides subsystem complexity.
//Improves usability.
//Client interacts with facade only.

class CPU {
    void start() {
        System.out.println("CPU Start");
    }
}

class Computer {
    CPU cpu = new CPU();

    void start() {
        cpu.start();
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        new Computer().start();
    }
}

