/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackL1;

import java.util.Stack;

/**
 *
 * @author krish
 */
public class StockSpan {

    private static void stockspan(int arr[]) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(0);
        for (int i = 0; i < arr.length; i++) {
            while (s.empty() == false && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            int span = s.empty() ? (i + 1) : (i - s.peek());
            System.out.print(span + " ");
            s.push(i);
        }
    }

    public static void main(String args[]) {

        stockspan(new int[]{15, 13, 12, 14, 15});
    }

}
