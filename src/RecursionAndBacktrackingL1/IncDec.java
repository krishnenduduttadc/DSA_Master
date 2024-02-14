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
public class IncDec {

    public static void main(String[] args) {
        inc(5);
        System.out.println("------------------------");
        dec(5);
    }

    static void dec(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("" + n);
        dec(n - 1);
    }

    static void inc(int n) {
        if (n == 0) {
            return;
        }

        inc(n - 1);
        System.out.println("" + n);
    }
}
