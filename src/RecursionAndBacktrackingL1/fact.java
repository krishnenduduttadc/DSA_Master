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
public class fact {

    public static void main(String[] args) {
        System.out.println(""+fact(6));
    }

    static int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            int prev = fact(n - 1);
            return n * prev;
        }
    }
}
