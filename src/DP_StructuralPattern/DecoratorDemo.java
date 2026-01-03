package DP_StructuralPattern;

//Adds behavior dynamically.
//Alternative to inheritance.
//Uses wrapping.
//Open for extension.

interface Coffee {
    int cost();
}

class SimpleCoffee implements Coffee {
    public int cost() {
        return 10;
    }
}

class MilkDecorator implements Coffee {
    Coffee c;

    MilkDecorator(Coffee c) {
        this.c = c;
    }

    public int cost() {
        return c.cost() + 5;
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee c = new MilkDecorator(new SimpleCoffee());
        System.out.println(c.cost());
    }
}

