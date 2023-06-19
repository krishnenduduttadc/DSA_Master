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
public class CountOfSubarrysWithEqual0and1 {
    public static void main(String[] args) {
        int arr[]={0,0,1,0,1,0,1,1,0,0,1,1,1};
        System.out.println(solution(arr));
    }
    
    static int solution(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        map.put(0,1);
        int sum=0;
        for(int val:arr){
            if(val==0){
                sum+=-1;
            }else{
                sum+=+1;
            }
            
            if(map.containsKey(sum)){
                ans+=map.get(sum);
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }
        
        return ans;
    }
}
