/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL1;

/**
 *
 * @author krish
 */
public class CountBinaryStrings {
    public static void main(String[] args) {
        int n=3;
        int[] dp0=new int[n+1];
        int[] dp1=new int[n+1];
        dp0[1]=1;
        dp1[1]=1;
        for(int i=2;i<=n;i++){
            dp1[i]=dp1[i-1]+dp0[i-1];
            dp0[i]=dp1[i-1];
        }
        System.out.println(""+dp1[n]+dp0[n]);
    }
}
