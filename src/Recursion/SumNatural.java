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
public class SumNatural {
    public static int recurSum(int n) 
    { 
        if (n <= 1) 
            return n; 
        return n + recurSum(n - 1); 
    } 
   
    public static void main(String args[]) 
    { 
        int n = 5; 
        System.out.println(recurSum(n)); 
    } 
}
