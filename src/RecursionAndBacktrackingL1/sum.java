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
public class sum {
    
    static int sum(int n){
        if(n==0){
            return 0;
        }
        else{
            int prevSum=sum(n-1);
            return n+prevSum;
        }
    }
    public static void main(String[] args) {
        System.out.println(""+sum(50));
    }
}
