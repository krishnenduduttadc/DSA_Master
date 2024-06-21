package Arrays3;


public class MajorityElement {

    public int majorityElement(int[] nums) {
        int val = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                val = nums[i];
                count = 1;
            } else if (nums[i] == val) {
                count++;
            } else {
                count--;
            }
        }

        return val;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3};
        int result2 = solution.majorityElement(nums2);
        System.out.println("Majority element: " + result2); // Expected output: 2
    }

}
