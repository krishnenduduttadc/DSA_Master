/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HML2;

import java.util.HashMap;

/**
 *
 * @author krish
 */
public class CountOfZerosSumSubarray {

    public static void main(String[] args) {
        int arr[] = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
        int p=sol(arr);
        System.out.println(p);
    }
    
    static int sol(int[] arr){
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=-1;
        int sum=0;
        map.put(0,1);
        while(i<arr.length-1){
            i++;
            sum+=arr[i];
            if(map.containsKey(sum)){
                count+=map.get(sum);
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }
        return count;
    }

}
