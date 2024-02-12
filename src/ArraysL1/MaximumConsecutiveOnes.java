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
public class MaximumConsecutiveOnes {

    public static void main(String a[]) {
         System.out.print(maxconone(new int[]{0, 1, 1, 0, 1, 1, 1}));
         System.out.print(maxone(new int[]{0, 1, 1, 0, 1, 1, 1}));
    }

    
    public static int maxone(int arr[]){
        int n=arr.length;
        int cnt=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                cnt=0;
            }else{
                cnt++;
                res=Math.max(res,cnt);
            }
        }
        return res;
    }
    

    private static int maxconone(int[] arr) {
        int res = 0, curr = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                curr = 0;
            } else {
                curr++;
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
