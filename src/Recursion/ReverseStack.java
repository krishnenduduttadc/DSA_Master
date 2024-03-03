/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

import java.util.Stack;

/**
 *
 * @author krish
 */
public class ReverseStack {

    static Stack<Character> st = new Stack<>();

    static void insertatbottom(char x) {
        if (st.isEmpty()) {
            st.push(x);
        } else {
            char a = st.peek();
            st.pop();
            insertatbottom(x);
            st.push(a);
        }

    }

    static void reverse(){
        if(st.size()>0){
            char c=st.peek();
            st.pop();
            reverse();
            insertatbottom(c);
        }
    }
    public static void main(String[] args) {

        // push elements into 
        // the stack 
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');

        System.out.println("Original Stack");

        System.out.println(st);

        // function to reverse  
        // the stack 
        reverse();

        System.out.println("Reversed Stack");

        System.out.println(st);
    }
}
