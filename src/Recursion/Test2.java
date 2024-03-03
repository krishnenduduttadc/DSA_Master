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
public class Test2 {
    
    static void fun1(int n){
        if(n==0){
            return;
        } 
        //System.out.println(n);
        fun1(n-1);
        System.out.println(n);
        //fun1(n-1);
    }
    public static void main(String a[]) {
        fun1(4);
        
    }
}
