/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathsL1;

/**
 *
 * @author krish
 */
public class FastPower {
    public static void main(String[] args) {
        System.out.println(""+fastpower(3, 5));
    }
    static int fastpower(int a,int b){
        int res=1;
        while(b>0){
            if((b&1)!=0){
                res=res*a;
            }
            a=a*a;
            b=b >> 1;
        }
        return res;
    }
}
