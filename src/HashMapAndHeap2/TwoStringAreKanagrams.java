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
public class TwoStringAreKanagrams {
    public static void main(String[] args) {
        String s1="ababaddccc";
        String s2="bcbecabacd";
        int k=4;
        System.out.println(anagrams(s1,s2,k));
    }

    private static boolean anagrams(String s1, String s2, int k) {
        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch=s1.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        
        for(int i = 0; i < s2.length(); i++) {
            char ch=s2.charAt(i);
            if(map.getOrDefault(ch, 0)>0){
                map.put(ch,map.get(ch)-1);
            }
        }
        
        int count=0;
        for(char ch:map.keySet()){
            count+=map.get(ch);
        }
        
        if(count>k){
            return false;
        }else{
            return true;
        }
    }
    
}
