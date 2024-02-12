/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

/**
 *
 * @author krishnendu
 */
public class Fact {

    public static void main(String a[]) {
        System.out.println(fact(4));
    }

    static int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
