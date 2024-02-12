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
public class MaximumSubArrSum {
    public static void main(String a[]) {
         System.out.print(maxsub(new int[]{-3,8,-2,4,-5,6}));
         
    }
    static int maxsub(int[] arr){
        int res=arr[0];
        int maxEnding=arr[0];
        for(int i=1;i<arr.length;i++){
            maxEnding=Math.max(maxEnding+arr[i],arr[i]);
            res=Math.max(res,maxEnding);
        }
        return res;
    }
}
