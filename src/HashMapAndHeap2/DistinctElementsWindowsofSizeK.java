/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapAndHeap2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author krish
 */
public class DistinctElementsWindowsofSizeK {
    public static void main(String[] args) {
        int arr[] = {2, 5, 5, 6, 3, 2, 3, 2, 4, 5, 2, 2, 2, 2, 3, 6};
        int k = 4;
        //int j;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> fm = new HashMap<Integer, Integer>();
        
        int i=0;
        
        while (i <= k-2) {
            fm.put(arr[i], fm.getOrDefault(arr[i], 0)+1);
            i++;
        }
        i--;
        int j=-1;
        while(i<arr.length-1){
            i++;
            fm.put(arr[i], fm.getOrDefault(arr[i], 0)+1); //accquire

            list.add(fm.size()); //work
            
            //release
            j++;
            int freq=fm.get(arr[j]);
            if(freq==1){
                fm.remove(arr[j]);
            }else{
                fm.put(arr[j],freq-1);
            }

        }
        
        System.out.println(""+list);
    }
}
