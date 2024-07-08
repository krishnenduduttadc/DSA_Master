package GraphL2;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class AlienDictionary {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Hardcoded input
        int n = 5;
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};

        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        // Initialize indegree map for all characters
        for (String st : words) {
            for (char ch : st.toCharArray()) {
                indegree.put(ch, 0);
            }
        }

        // Build the graph and calculate indegrees
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            boolean flag = false;

            int len = Math.min(curr.length(), next.length());

            for (int j = 0; j < len; j++) {
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);

                if (ch1 != ch2) {
                    HashSet<Character> set = map.getOrDefault(ch1, new HashSet<>());
                    if (!set.contains(ch2)) {
                        set.add(ch2);
                        map.put(ch1, set);
                        indegree.put(ch2, indegree.getOrDefault(ch2, 0) + 1);
                    }
                    flag = true;
                    break;
                }
            }

            if (!flag && curr.length() > next.length()) {
                return "";
            }
        }

        // Perform topological sorting using Kahn's algorithm
        LinkedList<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.addLast(c);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            char rem = q.removeFirst();
            ans.append(rem);
            count++;

            if (map.containsKey(rem)) {
                for (char nbr : map.get(rem)) {
                    indegree.put(nbr, indegree.get(nbr) - 1);
                    if (indegree.get(nbr) == 0) {
                        q.addLast(nbr);
                    }
                }
            }
        }

        if (count == indegree.size()) {
            return ans.toString();
        } else {
            return "";
        }
    }
}
