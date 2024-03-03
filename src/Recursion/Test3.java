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
public class Test3 {
    static int fun(int n){
        if(n==1){
            return 0;
        }else{
            return 1+fun(n/2);
        }
                
    }
    
    static void fun2(int n){
        if(n==0)
            return;
        fun2(n-1);
        System.out.println(n);
    }
    
    static void fun3(int n){
        if(n==0)
            return;
        
        System.out.println(n);
        fun3(n-1);
    }
    
    public static void main(String a[]) {
        System.out.println("----"+fun(16));
        fun2(4);
        
        fun2(4);
    }
}
