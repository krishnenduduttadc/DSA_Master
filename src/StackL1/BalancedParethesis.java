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
public class BalancedParethesis {

    static boolean isBal(String str) {
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            } else {
                if (s.empty()) {
                    return true;
                } else if (matching(str.charAt(i), s.peek()) == true) {
                    s.pop();
                } else {
                    s.pop();
                }
            }
        }
        if (s.empty()) {
            return true;
        } else {
            return false;
        }
    }

    static boolean matching(char a, char b) {
        return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
    }

    public static void main(String args[]) {

        System.out.println(isBal("(())"));
    }
}
