/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HML1;

import java.util.HashMap;

/**
 *
 * @author krish
 */
public class DistinctelementsinEveryWindow {
    
    
    static void printDistinct(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> m=new HashMap<>(); 
       
        for (int i = 0; i < k; i++) { 
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1); 
        } 
       
        System.out.print(m.size()+" "); 
       
        for (int i = k; i < n; i++) { 
            
            m.put(arr[i - k],  m.get(arr[i - k]) - 1);
            
            if (m.get(arr[i - k]) == 0) { 
                m.remove(arr[i-k]); 
            }   
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
            
            System.out.print(m.size()+" "); 
        } 
    }
    
    
     public static void main (String[] args) 
    {
        int arr[] = new int[]{10, 10, 5, 3, 20, 5};
        
        int n = arr.length;
        int k=4;
        printDistinct(arr, n, k);
        
    }
}
