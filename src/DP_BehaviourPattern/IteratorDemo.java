package DP_BehaviourPattern;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Iterator provides a way to access elements sequentially.
//It hides internal structure of collection.
//Supports multiple traversals.
//Common in Java Collections.

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}

