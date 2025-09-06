package CodeChef_java_coding_interview.logicalQuestions;

public class ProductOfArraExceptItself {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int res[] = product(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] product(int[] nums) {
        int left = 1;
        int right = 1;
        int[] product = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            product[i] = left;
            left *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            product[i] = right * product[i];
            right *= nums[i];
        }
        return product;
    }
}
