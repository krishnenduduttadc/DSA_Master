package HML2;

import java.util.HashSet;

public class CheckArithmeticSequence {
    public static boolean solution(int[] arr) {
        // write your code here
        if(arr.length<=1){
            return true;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int val:arr){
            min=Math.min(val,min);
            max=Math.max(val,max);
            set.add(val);
        }
        int d=(max-min)/(arr.length-1);
        for(int i=0;i<arr.length;i++){
            int ai=min+i*d;
            if(set.contains(ai)==false){
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1};
        System.out.println(solution(arr));
    }

}

