package Concepts;

import java.util.HashMap;

public class FreqMap {
    public static void main(String[] args) {
        String str="aaabbcc";
        HashMap<Character,Integer> hm=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        System.out.println(hm);
    }
}
