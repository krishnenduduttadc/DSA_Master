package ArraysL3;

public class ProductOfArrayExceptItself {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int[] res=productExceptSelf(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
