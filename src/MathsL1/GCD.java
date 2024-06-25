/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathsL1;

/**
 *
 * @author krish
 */
public class GCD {

    public static void main(String[] args) {
        System.out.println("" + gcd(30, 36));
    }
    

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
