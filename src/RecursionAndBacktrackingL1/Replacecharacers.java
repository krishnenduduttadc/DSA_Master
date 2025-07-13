/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

import java.util.Scanner;

/**
 * @author krish
 */
public class Replacecharacers {

    public static String replaceCharacter(String input, char c1, char c2) {

        if (input.length() == 0) {
            return input;
        }
        String small = replaceCharacter(input.substring(1), c1, c2);

        if (input.charAt(0) == c1) {
            return c2 + small;
        } else {
            return input.charAt(0) + small;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        char c1 = s.next().charAt(0);
        char c2 = s.next().charAt(0);
        System.out.println(replaceCharacter(input, c1, c2));
    }
}
