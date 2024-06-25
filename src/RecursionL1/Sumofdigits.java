/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionL1;

/**
 *
 * @author krish
 */
public class Sumofdigits {

    static int fun(int n) {
        if (n < 10) {
            return n;
        }
        return fun(n / 10) + n % 10;
    }

    public static void main(String a[]) {
        System.out.println("----" + fun(168));
    }
}
