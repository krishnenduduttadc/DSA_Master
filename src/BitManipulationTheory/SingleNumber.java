package BitManipulationTheory;

public class SingleNumber {
    public static void main(String[] args) {
        int arr[] = {2, 2, 3, 3, 4, 6,6};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
