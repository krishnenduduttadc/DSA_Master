/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

/**
 *
 * @author krish
 */
public class NthFibo {
    public static void main(String[] args) {
        System.out.println(fib(7));
    }

    private static int fib(int n) {
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        
        else{
            return fib(n-1)+fib(n-2);
        }
    }
}
