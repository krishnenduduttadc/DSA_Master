package DesignPattern_SOLIDPattern;


//Depend on abstractions.
//Not on concrete classes.
//Loose coupling.
//Easier testing.


interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Start");
    }
}

class Car {
    Engine e;

    Car(Engine e) {
        this.e = e;
    }
}

public class DIPDemo {
    public static void main(String[] args) {
        Car c = new Car(new PetrolEngine());
        c.e.start();
    }
}

