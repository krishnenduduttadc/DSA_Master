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
public class PairStar {

    public static String addStars(String s) {
        // Write your code here
        if (s.length() == 1) {
            return s;
        }
        String small = addStars(s.substring(1));
        if (s.charAt(0) == s.charAt(1)) {
            return s.charAt(0) + "*" + small;
        }
        return s.charAt(0) + small;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(addStars(input));
    }
}
