package SearchandSortL2;

import java.util.Arrays;

public class LargestPerimeterTraingle {
    public static int largestPerimeter(int[]nums) {
        //write your code here
        Arrays.sort(nums);

        int p = 0;

        for(int i = nums.length - 1; i >=2; i--){
            if(nums[i - 1] + nums[i - 2] > nums[i]){
                p = nums[i - 1] + nums[i - 2] + nums[i];
                break;
            }
        }

        return p;
    }

    public static void main(String[]args) {
        //input work

        int[]nums = {25,6,9,11,8,12,10,3,2};

        System.out.println(largestPerimeter(nums));
    }
}
