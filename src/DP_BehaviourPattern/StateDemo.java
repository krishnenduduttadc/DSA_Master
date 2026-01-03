package DP_BehaviourPattern;

//Object behavior changes with state.
//State represented as separate classes.
//Avoids complex if-else.
//Behavior is state-dependent.

interface State {
    void doAction();
}

class OnState implements State {
    public void doAction() {
        System.out.println("ON");
    }
}

class Context {
    State state;

    void setState(State s) {
        state = s;
    }
}

public class StateDemo {
    public static void main(String[] args) {
        Context c = new Context();
        c.setState(new OnState());
        c.state.doAction();
    }
}

