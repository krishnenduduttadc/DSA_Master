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
public class ToH {
    
    static void toh(int n,char src,char dest,char helper){
        
        if(n==0){
            return;
        }
        toh(n-1,src,helper,dest);
        System.out.println(src+"->"+dest);
        toh(n-1,helper,dest,src);
    }
    public static void main(String[] args) {
        toh(3,'A','C','B');
    }
}
