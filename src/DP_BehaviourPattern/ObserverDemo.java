package DP_BehaviourPattern;

import java.util.ArrayList;
import java.util.List;


//Defines one-to-many dependency.
//Observers get notified automatically.
//Used in event systems.
//Loose coupling between subject & observers.


interface Observer {
    void update(String msg);
}

class Subject {
    List<Observer> obs = new ArrayList<>();

    void add(Observer o) {
        obs.add(o);
    }

    void notifyAll(String msg) {
        obs.forEach(o -> o.update(msg));
    }
}

class User implements Observer {
    public void update(String msg) {
        System.out.println(msg);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        Subject s = new Subject();
        s.add(new User());
        s.notifyAll("Event happened");
    }
}

