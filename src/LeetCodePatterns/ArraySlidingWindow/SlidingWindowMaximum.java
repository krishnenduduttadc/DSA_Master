package LeetCodePatterns.ArraySlidingWindow;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        // Expected: [3,3,5,5,6,7]


    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> de = new LinkedList<Integer>();
        List<Integer> answers = new ArrayList<>();
        int n = nums.length;
        de.offer(0);
        for (int i = 1; i < k; i++) {
            while (de.size() > 0 && nums[de.peekLast()] < nums[i]) {
                de.removeLast();
            }
            de.offerLast(i);
        }
        answers.add(nums[de.peek()]);

        for (int j = k; j < n; j++) {
            int startingPoint = j - k + 1;
            while (de.size() > 0 && de.peek() < j - k + 1) {
                de.removeFirst();
            }
            while (de.size() > 0 && nums[de.peekLast()] < nums[j]) {
                de.removeLast();
            }
            de.offerLast(j);
            answers.add(nums[de.peek()]);
        }

        int[] ansArray = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            ansArray[i] = answers.get(i);
        }
        return ansArray;
    }
}
