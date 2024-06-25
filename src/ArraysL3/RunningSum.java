package ArraysL3;

public class RunningSum {
    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        return pre;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int[] res=runningSum(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
