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
public class SubsetofString {

    static void printSub(String str, String arr, int index) {
        int n = str.length();
        if (index == n) {
            System.out.println(arr);
            return;
        }
        printSub(str, arr + str.charAt(index), index + 1);
        printSub(str, arr, index + 1);
    }

    public static void main(String a[]) {
        String str = "abc";
        int index = 0;
        String curr = "";
        printSub(str, curr, index);
    }
}
