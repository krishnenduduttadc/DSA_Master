/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

/**
 *
 * @author krish
 */
public class CheckAB {

    public static void main(String[] args) {
        boolean b = checkAB("abababa");
        System.out.print("" + b);
    }

    public static boolean checkAB(String input) {
        // Write your code here

        if (input.length() == 0) {
            return true;
        }

        if (input.charAt(0) != 'a') {
            return false;
        }
        
        if (input.length()>=3 && input.substring(0, 3).equals("abb")) {
            return checkAB(input.substring(3));
        }
        return checkAB(input.substring(1));

    }
}
