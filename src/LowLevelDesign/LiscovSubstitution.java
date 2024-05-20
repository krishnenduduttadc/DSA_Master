package LowLevelDesign;

public class LiscovSubstitution {
    public static abstract class Shape {
        public abstract double calculateArea();
    }

    public static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }
    }

    // Derived class Square
    public static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double calculateArea() {
            return side * side;
        }
    }

    public static void main(String[] args) {
        // Create instances of Rectangle and Square
        Shape myRectangle = new Rectangle(5, 10);
        Shape mySquare = new Square(5);

        // Demonstrate Liskov Substitution Principle
        printArea(myRectangle); // Output: Area: 50.0
        printArea(mySquare);    // Output: Area: 25.0
    }

    // Method to print the area of a Shape
    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.calculateArea());
    }
}
