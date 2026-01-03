package DP_CreationalPattern;


//Ensures only one instance.
//Global access point.
//Private constructor.
//Used for logging/config.


class Singleton {
    private static Singleton obj = new Singleton();

    private Singleton() {
    }

    static Singleton getInstance() {
        return obj;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
    }
}

