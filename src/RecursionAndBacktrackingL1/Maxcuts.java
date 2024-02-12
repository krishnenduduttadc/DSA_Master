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
public class Maxcuts {
    static int maxcuts(int n,int a,int b,int c){
        if(n==0)return 0;
        if(n<0)return -1;
       
        int res=largest(maxcuts(n-a,a,b,c),maxcuts(n-b,a,b,c),maxcuts(n-c,a,b,c));
        if(res==-1)return -1;
        return res+1;
    }
    static int largest(int A,int B,int C){
        int largest = A > B ? (A > C ? A : C) : (B > C ? B : C); 
        return largest;
    }
    
    public static void main(String a[]) {
        System.out.println("----" + maxcuts(27,14,13,3));
    }
}
