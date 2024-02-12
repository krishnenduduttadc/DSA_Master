/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSortL1;

/**
 *
 * @author krish
 */
public class PairWithGivenSum {
    public static void main(String[] args) {
        System.out.println(pair(new int[]{10, 7, 8, 20, 12},32));
    }

    private static boolean pair(int[] arr, int x) {
        int left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]+arr[right]==x){
                return true;
            }else if(arr[left]+arr[right]>x){
                right--;
            }else{
                left++;
            }
        }return false;
    }
}
