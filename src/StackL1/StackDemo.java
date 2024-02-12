/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackL1;

/**
 *
 * @author krish
 */
public class StackDemo {

    static final char MAX = 1000;
    int top;
    char a[] = new char[MAX]; // Maximum size of Stack 

    boolean isEmpty() {
        return (top < 0);
    }

    StackDemo() {
        top = -1;
    }

    boolean push(char x) {
        if (top > MAX - 1) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println("Stack pushed");
            return true;
        }
    }

    char pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            char abc = a[top];
            top--;
            return abc;
        }
    }

    char peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            char x = a[top];
            return x;
        }
    }

    char top() {
        return a[top];
    }

    boolean empty() {
        if (a.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        StackDemo s = new StackDemo();
        s.push('a');
        s.push('b');
        s.push('c');
        s.push('d');
        s.push('e');
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.peek() + " Peeked from stack");
        System.out.println(s.top() + " is top of stack");
    }
}
