/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author krishnendu
 */
public class Test1 {

    public static void main(String a[]) {
        System.out.println(foo(6));
        //System.out.println(sum);
    }
    static long sum = 0;

    static int foo(int n) {
        if (n <=1) {
            return n;
        }
        //System.out.println(n+" ");
        //sum = sum + n;
        return foo(n - 1)+foo(n-2);
    }

}
