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
public class NraisedtopowerP {
    
    static int power(int n,int p){
        if(p==0){
            return 1;
        }else{
            int prevPower=power(n,p-1);
            return n*prevPower;
        }
    }
    public static void main(String[] args) {
        System.out.println(""+power(5,4));
    }
}
