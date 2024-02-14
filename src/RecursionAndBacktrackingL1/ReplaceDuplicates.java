/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

import java.util.Scanner;

/**
 *
 * @author krish
 */
public class ReplaceDuplicates {

    public static String removeConsecutiveDuplicates(String s) {
        // Write your code here

        if (s.length() == 1) {
            return s;
        }

        String small = removeConsecutiveDuplicates(s.substring(1));

        if (s.charAt(0) == small.charAt(0)) {
            return small;
        } else {
            return s.charAt(0) + small;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println(removeConsecutiveDuplicates(input));
    }
}
