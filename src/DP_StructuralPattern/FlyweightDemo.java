package DP_StructuralPattern;

//Reduces memory usage.
//Shares common objects.
//Immutable objects reused.
//Used in caching.

class Flyweight {
    static Flyweight obj = new Flyweight();

    private Flyweight() {
    }
}

public class FlyweightDemo {
    public static void main(String[] args) {
        System.out.println(Flyweight.obj);
    }
}

