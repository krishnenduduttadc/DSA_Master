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
public class StockbuyandSell {
    static int maxprofit(int[] arr){
        int n=arr.length;
        int profit=0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                profit=profit+(arr[i]-arr[i-1]);
            }
        }
        return profit;
    }
    public static void main(String a[]) {
        System.out.print(maxprofit(new int[]{1,5,3,8,12}));
    }
}
