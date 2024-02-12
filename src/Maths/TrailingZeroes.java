/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maths;

/**
 *
 * @author krish
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        int res=1000;
        int n=7;
        for(int i=5;i<=n;i=i*5){
            res=res+n/i;
        }
        System.out.println("zeroes: "+res);
    }
}
