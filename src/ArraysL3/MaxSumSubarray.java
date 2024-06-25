package ArraysL3;

public class MaxSumSubarray {
    public int maxSubArray(int[] nums) {
        int sum= 0;
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(sum<0){
                sum=nums[i];
            }else{
                sum = sum +nums[i];
            }

            ans= Math.max(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSumSubarray maxSumSubarray = new MaxSumSubarray();
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSumSubarray.maxSubArray(arr);
        System.out.println("Maximum sum of subarray: " + result); // Output should be 6 (subarray [4,-1,2,1])
    }

}
