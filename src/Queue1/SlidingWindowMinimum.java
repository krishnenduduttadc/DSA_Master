package Queue1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMinimum {
    public ArrayList<Integer> getMinimums(ArrayList<Integer> nums, int k) {
        int n = nums.size();

        ArrayList<Integer> ans = new ArrayList<>();
        if (k > n) return ans;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (deque.size() > 0 && deque.getLast() > nums.get(i)) deque.removeLast();
            deque.addLast(nums.get(i));
        }
        ans.add(deque.getFirst());
        for (int i = k; i < n; i++) {
            if (nums.get(i - k) == deque.getFirst()) deque.removeFirst();
            while (deque.size() > 0 && deque.getLast() > nums.get(i)) deque.removeLast();
            deque.addLast(nums.get(i));
            ans.add(deque.getFirst());

        }
        return ans;
    }


    public static void main(String[] args) {
        SlidingWindowMinimum swm = new SlidingWindowMinimum();

        // Test case 1
        ArrayList<Integer> nums1 = new ArrayList<>(List.of(1, 3, -1, -3, 5, 3, 6, 7));
        int k1 = 3;
        ArrayList<Integer> result1 = swm.getMinimums(nums1, k1);
        System.out.println("Minimums for nums1 and k=" + k1 + ": " + result1);

    }
}
