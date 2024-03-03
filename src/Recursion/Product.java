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
public class Product {
    static int product(int x, int y) 
    { 
        if(x<0 || y<0){
            return product(Math.abs(x),Math.abs(y));
        }
        if(x<y){
            return product(y,x);
        }
        
        if(x==0 || y==0){
            return 0;
        }else{
            return x+product(x,y-1);
        }
    }
    public static void main (String[] args) 
    { 
        int x = 5, y = -20; 
        System.out.println(product(x, y));  
    } 
}
