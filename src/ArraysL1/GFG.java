/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krish
 */
class GFG { 
    public static void main(String[] args) 
    { 
        List<Integer> al = new ArrayList<Integer>(); 
        al.add(10); 
        al.add(20); 
        al.add(30); 
        al.add(40); 
  
        // Error: incompatible types: Object[] 
        // cannot be converted to Integer[] 
        Integer[] objects = (Integer[]) al.toArray(); 
  
        for (Integer obj : objects) 
            System.out.println(obj); 
    } 
}
