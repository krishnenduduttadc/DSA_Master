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
public class RemoveX {

    // Return the changed string
    public static String removeX(String input) {
        // Write your code here
        char a = 'x';
        return removeX(input, a);

    }

    public static String removeX(String input, char a) {

        if (input.length() == 0) {
            return input;
        }
        String small = removeX(input.substring(1), a);

        if (input.charAt(0) == a) {
            return small;
        } else {
            return input.charAt(0) + small;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(removeX(input));
    }
}
