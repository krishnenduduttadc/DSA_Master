package QueueL1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        // Hardcoded input string
        String A = "aabc";

        // Create an instance of the Solution class
        FirstNonRepeatingCharacter solution = new FirstNonRepeatingCharacter();

        // Call the FirstNonRepeating method and store the result
        String result = solution.FirstNonRepeating(A);

        // Print the result
        System.out.println(result);
    }

    public String FirstNonRepeating(String A) {
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] ans = new char[A.length()];

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            q.add(c);
            hm.put(c, hm.getOrDefault(c, 0) + 1);

            while (!q.isEmpty() && hm.get(q.peek()) > 1) {
                q.remove();
            }

            if (!q.isEmpty()) {
                ans[i] = q.peek();
            } else {
                ans[i] = '#';
            }
        }

        return String.valueOf(ans);
    }
}
