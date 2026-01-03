package DP_BehaviourPattern;


//Command pattern encapsulates a request as an object.
//It decouples the sender from the receiver.
//Allows undo/redo operations easily.
//Each command implements a common interface.

interface Command {
    void execute();
}

class Light {
    void on() {
        System.out.println("Light ON");
    }
}

class LightOnCommand implements Command {
    Light light;

    LightOnCommand(Light l) {
        light = l;
    }

    public void execute() {
        light.on();
    }
}

public class CommandDemo {
    public static void main(String[] args) {
        Command cmd = new LightOnCommand(new Light());
        cmd.execute();
    }
}
