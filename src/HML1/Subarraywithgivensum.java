/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HML1;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author krish
 */
public class Subarraywithgivensum {
     public static void main (String[] args) 
    {
        int arr[] = new int[]{5, 8, 6, 13, 3, -1};
        int sum=22;
        int n = arr.length;
        
        System.out.println(isSum(arr, n, sum));
        
    }
    
    static boolean isSum(int arr[], int n, int sum)
    {
        Set<Integer> s = new HashSet<Integer>();
        int pre_sum = 0;
        for(int i = 0; i < n; i++)
        {
            if(pre_sum==sum)
                return true;
            pre_sum += arr[i];
            if(s.contains(pre_sum-sum) == true)
                return true;
              
            s.add(pre_sum);
        }
        
        return false;
    }
}
