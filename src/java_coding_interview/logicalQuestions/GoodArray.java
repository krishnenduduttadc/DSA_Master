package java_coding_interview.logicalQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class GoodArray {
    public static void main(String[] args) {
        int n = 4;
        int A[] = {8, 3, 5, 2};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.put(A[i], 1);
        }
        long sum = Arrays.stream(A).sum();
        for (int i = 0; i < n; i++) {
            long temp=sum- A[i];
            if(map.get(A[i]) >1){
                long y=map.lastKey();
                if(y==temp-y){
                    list.add(i+1);
                }
            }else{
                map.remove(A[i]);
                long y=map.lastKey();
                if(y==temp-y){
                    list.add(i+1);
                }
                map.put(A[i],1);
            }
        }
        System.out.println(list.size());
    }
}
