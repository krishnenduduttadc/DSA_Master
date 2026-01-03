package DP_SOLIDPattern;

//Open for extension.
//Closed for modification.
//Use interfaces/abstract classes.
//Reduces bugs.

interface Shape {
    int area();
}

class Square implements Shape {
    public int area() {
        return 4;
    }
}

public class OCPDemo {
    public static void main(String[] args) {
        Shape s = new Square();
        System.out.println(s.area());
    }
}

