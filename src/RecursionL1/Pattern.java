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
public class Pattern {
    
    static void printPattern(int n) 
    { 
        if(n<=0){
            System.out.print(n + " "); 
            return;
        }
        System.out.print(n + " "); 
        printPattern(n-5);
        System.out.print(n + " "); 
    }
    
    public static void main(String[] args) 
    { 
          
        int n = 16;          
        printPattern(n); 
    } 
}
