package HML2;

import java.util.HashMap;

public class CountOfSubarraysHavingSumEqualsToK {

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int target = 2;
        System.out.println(solution(arr,target));
    }

    public static int solution(int[] arr, int target){
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
            if(map.containsKey(sum-target)){
                ans+=map.get(sum-target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
