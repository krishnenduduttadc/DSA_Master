package TwoPointerL1;

import java.util.Arrays;

public class TwoSum {

        public class pair implements Comparable<pair>{
            int num;
            int idx;
            pair(int num , int idx){
                this.num = num;
                this.idx = idx;
            }
            public int compareTo(pair O){
                if(this.num != O.num) return this.num-O.num;
                else return this.idx-O.idx;
            }

        }
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            pair[] arr=  new pair[n];
            for(int i = 0; i<n; i++){
                arr[i] = new pair(nums[i] ,i);
            }
            Arrays.sort(arr);

            int i = 0;
            int j = n-1;
            while(i<j){
                int left = arr[i].num;
                int right = arr[j].num;
                int sum = left+right;
                if(sum == target) return new int[]{arr[i].idx , arr[j].idx};
                else if(sum<target) i++;
                else j--;
            }
            return new int[2];
        }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        TwoSum solution = new TwoSum();

        // Hardcoded input array and target
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Calling twoSum to find indices of the two numbers that add up to target
        int[] result = solution.twoSum(nums, target);

        // Printing the indices
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

}
