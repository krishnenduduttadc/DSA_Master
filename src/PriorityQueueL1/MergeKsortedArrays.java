/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityQueueL1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author krish
 */
public class MergeKsortedArrays {

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
         */
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>();
        int x = input.size();
        for (int i = 0; i < x; i++) {
            for (int k = 0; k < input.get(i).size(); k++) {
                heap2.add(input.get(i).get(k));
            }
        }
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.addAll(heap2);
        Collections.sort(a1);
        return a1;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(5);
        a1.add(9);
        input.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(45);
        a2.add(90);
        input.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(2);
        a3.add(6);
        a3.add(78);
        a3.add(100);
        a3.add(234);
        input.add(a3);

        ArrayList<Integer> input2 = mergeKSortedArrays(input);

        for (int i = 0; i < input2.size(); i++) {
            System.out.print(input2.get(i) + " ");
        }

    }
}

