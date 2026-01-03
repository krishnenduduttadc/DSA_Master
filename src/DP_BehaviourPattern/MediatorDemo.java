package DP_BehaviourPattern;


//Mediator reduces direct communication between objects.
//Objects communicate via mediator only.
//Promotes loose coupling.
//Centralizes control logic.

class Mediator {
    void send(String msg) {
        System.out.println("Message: " + msg);
    }
}

class User1 {
    Mediator mediator;

    User1(Mediator m) {
        mediator = m;
    }

    void send(String msg) {
        mediator.send(msg);
    }
}

public class MediatorDemo {
    public static void main(String[] args) {
        User1 u = new User1(new Mediator());
        u.send("Hello");
    }
}

