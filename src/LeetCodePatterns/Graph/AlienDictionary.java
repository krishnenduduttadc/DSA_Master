package LeetCodePatterns.Graph;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};

        Solution solution = new Solution();
        String order = solution.alienOrder(words);

        System.out.println("Alien Dictionary Order: " + order);
    }

    static class Solution {
        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();
            Map<Character, Integer> indegree = new HashMap<>();

            // Initialize graph and indegree
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    graph.putIfAbsent(c, new HashSet<>());
                    indegree.putIfAbsent(c, 0);
                }
            }

            // Build graph
            for (int i = 0; i < words.length - 1; i++) {
                String current = words[i];
                String next = words[i + 1];
                int length = Math.min(current.length(), next.length());

                for (int j = 0; j < length; j++) {
                    char c1 = current.charAt(j);
                    char c2 = next.charAt(j);

                    if (c1 != c2) {
                        if (!graph.get(c1).contains(c2)) {
                            graph.get(c1).add(c2);
                            indegree.put(c2, indegree.get(c2) + 1);
                        }
                        break;
                    }

                    if (j == next.length() - 1 && current.length() > next.length()) {
                        return ""; // Invalid order
                    }
                }
            }

            // Topological sort
            StringBuilder result = new StringBuilder();
            Queue<Character> queue = new LinkedList<>();
            for (char c : indegree.keySet()) {
                if (indegree.get(c) == 0) {
                    queue.offer(c);
                }
            }

            while (!queue.isEmpty()) {
                char current = queue.poll();
                result.append(current);

                for (char neighbor : graph.getOrDefault(current, new HashSet<>())) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            if (result.length() != indegree.size()) {
                return "";
            }

            return result.toString();
        }
    }
}

