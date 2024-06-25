/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionL1;

import java.util.ListIterator;
import java.util.Stack;

/**
 *
 * @author krish
 */
public class SortaStack {

    static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int tmp = s.pop();
        sortedInsert(s, x);
        s.push(tmp);
    }
    static void sortStack(Stack<Integer> s) 
    {
        if (!s.isEmpty()) 
        { 
            int x=s.pop();
            sortStack(s);
            sortedInsert(s,x);
        }
    }

    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding 
        while (lt.hasNext()) {
            lt.next();
        }

        // printing from top to bottom 
        while (lt.hasPrevious()) {
            System.out.print(lt.previous() + " ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);

              
        sortStack(s);

        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);

    }
}
