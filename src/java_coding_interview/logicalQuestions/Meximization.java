package java_coding_interview.logicalQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class Meximization {
    public static void main(String[] args) {
        int n=7;
        int[] arr={4,2,0,1,3,3,7};
        Arrays.sort(arr);
        ArrayList<Integer> repeted_numbers=new ArrayList<>();
        System.out.println(arr[0]+" ");
        for (int i = 1; i < n; i++) {
            if(arr[i]==arr[i-1]){
                repeted_numbers.add(arr[i]);
            }else{
                System.out.println(arr[i]+" ");
            }
        }

        for (int i = 0; i < repeted_numbers.size(); i++) {
            System.out.println(repeted_numbers.get(i)+" ");
        }

        System.out.println("");
    }
}
