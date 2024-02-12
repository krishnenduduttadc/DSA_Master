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
public class AtoiRec {

    static int myAtoiRecursive(String str, int n) {
        if (n == 1) {
            return str.charAt(0) - '0';
        }

        return (10 * myAtoiRecursive(str, n - 1)+ str.charAt(n - 1) - '0');
    }

    public static void main(String a[]) {
        String str = "112889000";
        int n = str.length();

        System.out.println(myAtoiRecursive(str, n));
    }
}
