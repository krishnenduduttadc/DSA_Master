package DesignPattern_BehaviourPattern;


//Defines family of algorithms.
//Encapsulates each algorithm.
//Interchangeable at runtime.
//Avoids conditional logic.


interface Strategy {
    int execute(int a, int b);
}

class Add implements Strategy {
    public int execute(int a, int b) {
        return a + b;
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Strategy s = new Add();
        System.out.println(s.execute(2, 3));
    }
}

