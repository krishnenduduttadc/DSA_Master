package ArraysL2;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {
    public static void main(String[] args) {
        int dupli[] = {1, 1, 2, 2, 3, 4, 4};
        List<Integer> dup = dups(dupli);

        for (int i = 0; i < dup.size(); i++) {
            System.out.println(dup.get(i));
        }
    }

    static List<Integer> dups(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            int val = nums[idx];
            if (val < 0) {
                res.add(idx + 1);
            } else {
                nums[idx] *= -1;
            }
        }
        return res;
    }
}
