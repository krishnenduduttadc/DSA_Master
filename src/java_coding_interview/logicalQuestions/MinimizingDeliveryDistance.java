package java_coding_interview.logicalQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimizingDeliveryDistance {
    public static void main(String[] args) {

        int k=3;
        long[] arr={-5,-10,-15,-20,-25,-30,6,5,8,3,7,4};
        int n=arr.length;
        Arrays.sort(arr);
        long ans=-Math.max(Math.abs(arr[0]),Math.abs(arr[n-1]));
        ArrayList<Long> negative=new ArrayList<>();
        ArrayList<Long> positive=new ArrayList<>();

        for (long i:arr) {
            if(i<0){
                negative.add(i);
            }else if(i>0){
                positive.add(i);
            }
        }

        for (int i = 0; i <negative.size() ; i+=k) {
            ans+=2*Math.abs(negative.get(i));
        }

        for (int i = positive.size()-1; i >=0 ; i-=k) {
            ans+=2*positive.get(i);
        }
        System.out.println(ans);
    }
}
