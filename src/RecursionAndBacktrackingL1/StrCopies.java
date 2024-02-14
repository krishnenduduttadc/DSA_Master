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
public class StrCopies {

    public static void main(String[] args) {
        boolean p = strCopies("catcowcat", "cat", 2);
        System.out.println("" + p);
    }

    public static boolean strCopies(String str, String sub, int n) {
        if (n == 0) {
            return true;
        }

        if (str.length() < sub.length()) {
            return false;
        }

        if (str.substring(
                0, sub.length()).equals(sub)) {
            return strCopies(str.substring(1), sub, n - 1);
        }

        return strCopies(str.substring(1), sub, n);
    }

}
