/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapAndHeap2;

import java.util.HashMap;

/**
 *
 * @author krish
 */
public class ArrayPairDivisileByK {
    public static void main(String[] args) {
        int arr[]={22,12,45,55,65,78,88,75};
        int k=7;
        sol(arr,k);
    }

    private static void sol(int[] arr, int k) {
        HashMap<Integer,Integer> rfmap=new HashMap<>();
        
        for(int val:arr){
            int rem=val%k;
            int of=rfmap.getOrDefault(rem, 0);
            rfmap.put(rem, of+1);
        }
        
        
        for(int val:arr){
            int rem=val%k;
            
            if(rem==0){
               int fq=rfmap.get(rem) ;
               if(fq%2==1){
                   System.out.println(false);
                   return;
               }            
            }
            
            else if(2*rem==k){
                int fq=rfmap.get(rem);
                if(fq%2==1){
                    System.out.println(false);
                    return;
                }
            }
            else{
                int fq=rfmap.get(rem);
                int ofq=rfmap.getOrDefault(k-rem,0);
                if(fq!=ofq){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }
    
}
