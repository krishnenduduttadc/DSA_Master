package LeetCodePatterns.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
// Expected: [[-1, -1, 2], [-1, 0, 1]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int i = 0;
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        while (i < nums.length) {
            if (i == 0 || (i - 1 >= 0 && nums[i - 1] != nums[i])) {
                int firstNo = nums[i];
                int target = -firstNo;
                List<List<Integer>> pairs = twoSum(nums, i + 1, nums.length - 1, target);
                for (List<Integer> pair : pairs) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(firstNo);
                    triplet.add(pair.get(0));
                    triplet.add(pair.get(1));
                    triplets.add(triplet);
                }
            }
            i++;
        }

        return triplets;

    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> pairs = new ArrayList<>();

        int f = start;
        int s = end;

        while (f < s) {
            if (f - 1 >= start && nums[f - 1] == nums[f]) {
                f++;
                continue;
            }
            if (s + 1 <= end && nums[s + 1] == nums[s]) {
                s--;
                continue;
            }

            if (nums[f] + nums[s] < target) {
                f++;
            } else if (nums[f] + nums[s] > target) {
                s--;
            } else {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[f]);
                pair.add(nums[s]);
                pairs.add(pair);
                f++;
            }
        }

        return pairs;
    }
}
