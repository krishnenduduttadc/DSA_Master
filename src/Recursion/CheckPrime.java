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
public class CheckPrime {
    
    static boolean isPrime(int n, int i) 
    {
        if (n <= 2) 
            return (n == 2) ? true : false; 
        if(n%i==0)
            return false;
        if (i * i > n) 
            return true; 
         return isPrime(n, i + 1); 
    }
    public static void main(String[] args) 
    { 
  
        int n = 15; 
  
        if (isPrime(n, 2))  
            System.out.println("Yes"); 
        else 
            System.out.println("No"); 
    } 
}
