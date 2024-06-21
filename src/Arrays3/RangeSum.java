package Arrays3;

public class RangeSum {
    static int[] psum;
    public static void NumArray(int[] nums) {
        psum = new int[nums.length];
        psum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            psum[i] = psum[i - 1] + nums[i];
    }

    public static int sumRange(int i, int j) {
        if(i == 0)
            return psum[j];

        return psum[j] - psum[i - 1];
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        NumArray(arr);
        int res=sumRange(1,2);
        System.out.println(res);
    }

}
