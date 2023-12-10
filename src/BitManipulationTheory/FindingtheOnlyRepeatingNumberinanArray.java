package BitManipulationTheory;

public class FindingtheOnlyRepeatingNumberinanArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2}; // One element (2) repeats
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i < nums.length; i++) {
            xor ^= i;
        }
        System.out.println("Repeating number: " + xor); // Output: 2
    }
}
