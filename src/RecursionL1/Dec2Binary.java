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
public class Dec2Binary {

    static void fun(int n) {
        if (n == 0) {
            return;
        }

        fun(n / 2);
        System.out.print(n % 2);

    }
    

    public static void main(String a[]) {
        fun(15);
    }
}
