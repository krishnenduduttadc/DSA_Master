package HML2;

import java.util.HashSet;

public class PairWithEqualSum {
    public static void main(String[] args) {
        int arr[]={2,9,3,5,8,6,4};
        boolean ans=sol(arr);
        System.out.println(ans);
    }

    private static boolean sol(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum=arr[i]+arr[j];
                if(set.contains(sum)){
                    return true;
                }else{
                    set.add(sum);
                }
            }
        }
        return false;
    }
}
