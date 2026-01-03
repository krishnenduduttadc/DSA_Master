package DesignPattern_CreationalPattern;


//Creates objects by cloning.
//Avoids costly creation.
//Uses clone method.
//Copies existing object.


class Proto implements Cloneable {
    int x = 10;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class PrototypeDemo {
    public static void main(String[] args) throws Exception {
        Proto p1 = new Proto();
        Proto p2 = (Proto) p1.clone();
        System.out.println(p2.x);
    }
}

