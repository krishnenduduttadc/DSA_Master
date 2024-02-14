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
public class String2int {

    public static int convertStringToInt(String input) {
        // Write your code here

        if (input.length() == 1) {
            return (input.charAt(0) - '0');
        }

        double y = convertStringToInt(input.substring(1));
        double x = input.charAt(0) - '0';
        x = x * Math.pow(10, input.length() - 1) + y;
        return (int) (x);

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(convertStringToInt(input));
    }

}
