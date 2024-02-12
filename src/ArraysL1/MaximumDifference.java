/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;

/**
 *
 * @author krish
 */
public class MaximumDifference {
    public static void main(String a[]) {
         System.out.println(""+maxDiff(new int[]{2, 3,10,6,4,8,1}));
         
     }

    private static int maxDiff(int[] arr) {
        int n=arr.length;
        int res=arr[1]-arr[0];
        int minval=arr[0];
        
        for(int j=1;j<n;j++){
            res=Math.max(arr[j]-minval,res);
            minval=Math.min(minval, arr[j]);
        }
        return res;
    }

}
