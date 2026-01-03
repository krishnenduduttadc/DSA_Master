package DesignPattern_StructuralPattern;


//Converts one interface to another.
//Allows incompatible classes to work.
//Acts as wrapper.
//Promotes reuse.

class Old {
    void oldMethod() {
        System.out.println("Old");
    }
}

class Adapter {
    Old o = new Old();

    void newMethod() {
        o.oldMethod();
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        new Adapter().newMethod();
    }
}

