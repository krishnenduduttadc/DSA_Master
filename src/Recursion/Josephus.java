/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author krish
 */
public class Josephus {
    static int jos(int n,int k){
        if(n==1)return 0;
        return (jos(n-1,k)+k)%n;
    }
    public static void main(String a[]) {
        System.out.println(""+jos(5,3));
    }
}
