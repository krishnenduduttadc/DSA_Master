package ArraysL2;

import java.util.*;

public class TwoSum {
    public static List<List<Integer>> twoSum(int[] arr, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);


        while(left < right) {
            if(left != 0 && arr[left] == arr[left - 1]){
                left++;
                continue;
            }

            int sum = arr[left] + arr[right];

            if(sum == target) {
                List<Integer> Subres = new ArrayList<>();
                Subres.add(arr[left]);
                Subres.add(arr[right]);

                res.add(Subres);
                left++;
                right--;
            } else if(sum > target){
                right--;
            } else {
                left++;
            }

        }
        return res;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        int[] arr = {2,2,4,3,1,6,6,7,5,9,1,8,9};
        int target = 10;
        List<List<Integer>> res = twoSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }
}
