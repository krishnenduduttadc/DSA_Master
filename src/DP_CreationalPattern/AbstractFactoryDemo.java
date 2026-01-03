package DP_CreationalPattern;

//Creates families of related objects.
//Without specifying concrete classes.
//Promotes consistency.
//Uses interface for factories.

interface Shape {
    void draw();
}

interface Factory {
    Shape create();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Circle");
    }
}

class ShapeFactory implements Factory {
    public Shape create() {
        return new Circle();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        Factory f = new ShapeFactory();
        f.create().draw();
    }
}
