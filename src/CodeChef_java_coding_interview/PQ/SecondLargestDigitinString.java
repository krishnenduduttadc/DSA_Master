package CodeChef_java_coding_interview.PQ;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SecondLargestDigitinString {
    public static void main(String[] args) {
        String s = "dfa12321afd";
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> b - a
        );
        int pointer = 0;
        while (pointer < s.length()) {
            char c = s.charAt(pointer);
            if (Character.isDigit(c)) {
                if (!set.contains(c - '0')) {
                    pq.add(c - '0');
                    set.add(c - '0');
                }
            }
            pointer++;
        }

        int result = 0;
        if (pq.size() < 2) {
            result = -1;
        } else if (pq.size() > 1) {
            pq.poll();
            result = pq.poll();
        }

        System.out.println(result);
    }
}
