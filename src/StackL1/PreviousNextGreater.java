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
public class PreviousNextGreater {

    static void prevGreater(int arr[]) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(arr[0]);
        System.out.print(-1+" ");

        for (int i = 1; i < arr.length; i++) {
            while (s.empty() && s.peek() <= arr[i]) {
                s.pop();
            }
            int pg = s.empty() ? -1 : s.peek();
            System.out.print(pg + " ");
            s.push(arr[i]);
        }
    }

    static void nextGreater(int arr[]) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(arr[arr.length - 1]);
        System.out.print(-1+" ");
        for(int i=arr.length-2;i>=0;i--){
            while(s.empty() && s.peek()<=arr[i]){
                s.pop();
            }
            int pg = s.empty() ? -1 : s.peek();
            System.out.print(pg + " ");
            s.push(arr[i]);
        }
    }

    public static void main(String args[]) {
        prevGreater(new int[]{15, 13, 12, 14, 15});
        System.out.println();
        nextGreater(new int[]{15, 13, 12, 14, 15});
    }
}
