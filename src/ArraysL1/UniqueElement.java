/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;
import java.util.*;
/**
 *
 * @author krish
 */
public class UniqueElement {
    public static void main(String[] args) {
        int arr[] = {1, 3, 1, 3, 6, 6, 7, 10, 7};
        
        System.out.println(""+findUnique(arr));
    }
    
    
    static int findUnique(int arr[])
    {
        int c=0;
        int n = arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int key=arr[i];
            if(hm.containsKey(key)){
                hm.put(arr[i],hm.get(arr[i])+1);
            }else{
                hm.put(arr[i],1);
            }
        }

        for(Map.Entry<Integer, Integer> itr: hm.entrySet()){
             //System.out.println(itr.getKey() + " " + itr.getValue());
             if(itr.getValue()==1){
                 c=itr.getKey();
             }
        }
        return c;   
    }
}
