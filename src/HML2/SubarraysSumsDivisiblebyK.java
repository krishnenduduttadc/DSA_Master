package HML2;

import java.util.HashMap;

public class SubarraysSumsDivisiblebyK {
    public static void main(String[] args) {
        int arr[] = {2, -6, 3, 1, 2, 8, 2, 1};
        int k = 7;
        System.out.println(sol(arr,k));
    }

    static int sol(int[] arr, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int rem = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if(map.containsKey(rem)){
                ans+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            }else{
                map.put(rem,1);
            }
        }
        return ans;
    }
}
