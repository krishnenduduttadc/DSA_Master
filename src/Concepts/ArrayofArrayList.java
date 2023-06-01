package Concepts;

import java.util.*;

public class ArrayofArrayList {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer>[] al = new ArrayList[n];

        // initializing
        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<Integer>();
        }

        // We can add any number of columns to each
        // rows as per our wish
        al[0].add(1);
        al[0].add(2);
        al[1].add(2);
        al[1].add(1);
        al[1].add(3);
        al[2].add(3);
        al[2].add(2);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < al[i].size(); j++) {
                System.out.print(al[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}
