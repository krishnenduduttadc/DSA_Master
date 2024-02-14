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
public class CheckPalin {

    public static boolean isStringPalindrome(String input) {
        // Write your code here

        int s = 0;
        int e = input.length() - 1;

        return isStringPalindrome(input, s, e);

    }

    public static boolean isStringPalindrome(String input, int s, int e) {
        if (s == e) {
            return true;
        }
        if (input.charAt(s) != input.charAt(e)) {
            return false;
        }
        if (s < e + 1) {
            return isStringPalindrome(input, s + 1, e - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStringPalindrome("abba"));
    }
}
