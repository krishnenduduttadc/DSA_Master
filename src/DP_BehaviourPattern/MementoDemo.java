package DP_BehaviourPattern;


//Memento saves and restores object state.
//Without exposing internal details.
//Used for undo operations.
//State stored in separate object.


class Memento {
    String state;

    Memento(String s) {
        state = s;
    }
}

class Originator {
    String state;

    Memento save() {
        return new Memento(state);
    }

    void restore(Memento m) {
        state = m.state;
    }
}

public class MementoDemo {
    public static void main(String[] args) {
        Originator o = new Originator();
        o.state = "A";
        Memento m = o.save();
        o.state = "B";
        o.restore(m);
        System.out.println(o.state);
    }
}

