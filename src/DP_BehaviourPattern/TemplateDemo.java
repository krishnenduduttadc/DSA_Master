package DP_BehaviourPattern;


//Defines skeleton of algorithm.
//Steps implemented by subclasses.
//Ensures consistent structure.
//Uses inheritance.

abstract class Game {
    abstract void play();

    void start() {
        System.out.println("Start");
        play();
    }
}

class Cricket extends Game {
    void play() {
        System.out.println("Play Cricket");
    }
}

public class TemplateDemo {
    public static void main(String[] args) {
        new Cricket().start();
    }
}

