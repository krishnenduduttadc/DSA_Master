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
public class TraprainWater {
    
     public static void main(String a[]) {
        System.out.print(getWater(new int[]{3,0,1,2,5}));
    }

    private static int getWater(int[] arr) {
       
        int res=0;
        for(int i=0;i<arr.length;i++){
            int lmax=arr[i];
            for(int j=0;j<i;j++){
                lmax=Math.max(arr[j], lmax);
            }
            int rmax=arr[i];
            for(int j=i+1;j<arr.length;j++){
                rmax=Math.max(arr[j], rmax);
            }
            
            res=res+(Math.min(lmax,rmax)-arr[i]);
        }
       return res; 
    }
}
