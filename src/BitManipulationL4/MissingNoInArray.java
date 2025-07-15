package BitManipulationL4;

public class MissingNoInArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 4};
        int missing = 0;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        missing ^= nums.length;
// 'missing' now contains the missing number (2 in this case)
        System.out.println(missing);
    }
}
