/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;

import java.util.Arrays;

/**
 *
 * @author krish
 */
public class MaximumProfit {

    public static int maximumProfitOnApp(int[] arr) {

        Arrays.sort(arr);
        int[] profit=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            profit[i]=(arr.length-i)*arr[i];
        }
        
        int max=profit[0];
        for (int i = 1; i < profit.length; i++) {
            if(profit[i]>max){
                max=profit[i];
            }
        }
        return max;
        
  
    }

    public static void main(String[] args) {
        int[] arr = {30, 20, 14, 53};
        System.out.println(maximumProfitOnApp(arr));

    }
}
