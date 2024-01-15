package HML2;

import java.util.HashSet;

public class LargestSubarrayWithContiguousElements {
    public static int solution(int[] arr) {
        // write your code here
        int ans=0;
        for (int i = 0; i < arr.length-1; i++) {
            int min=arr[i];
            int max=arr[i];
            HashSet<Integer> cd=new HashSet<>();
            cd.add(arr[i]);

            for(int j=i+1;j<arr.length;j++){
                if(cd.contains(arr[j])){
                    break;
                }
                cd.add(arr[j]);
                min=Math.min(min,arr[j]);
                max=Math.max(max,arr[j]);

                if(max-min==j-i){
                    int len=j-i+1;
                    if(len>ans){
                        ans=len;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 11};
        System.out.println(solution(arr));
    }

}


