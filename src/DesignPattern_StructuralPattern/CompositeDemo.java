package DesignPattern_StructuralPattern;


//Treats individual and group objects uniformly.
//Tree structure.
//Simplifies client code.
//Uses recursion.

interface Component {
    void show();
}

class Leaf implements Component {
    public void show() {
        System.out.println("Leaf");
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        Component c = new Leaf();
        c.show();
    }
}

