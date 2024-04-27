package HML1;

import java.util.HashMap;

public class LongestConsecutiveSequenceOfElements {
    public static void main(String[] args) throws Exception {
        int[] arr={17, 12, 5, 1, 2, 10, 2, 13, 7, 11, 8, 9, 11, 8, 9, 5, 6, 11};
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int a:arr){
            map.put(a,true);
        }

        for(int val:arr){
            if(map.containsKey(val-1)){
                map.put(val,false);
            }
        }

        int msp=0;
        int ml=0;
        for(int val:arr){
            if(map.get(val)==true){
                int tl=1;
                int tsp=val;
                while(map.containsKey(tsp+tl)){
                    tl++;
                }
                if(tl>ml){
                    msp=tsp;
                    ml=tl;
                }
            }
        }

        for(int i=0;i<ml;i++){
            System.out.println(msp+i);
        }
    }
}


