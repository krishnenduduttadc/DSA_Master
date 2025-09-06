package LeetCodePatterns.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    private List<List<Integer>> adj = new ArrayList<>();
    private Map<Integer, String> state = new HashMap<>();
    private boolean cycleFound = false;

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};

        CourseSchedule solution = new CourseSchedule();

        System.out.println("Can finish courses (test 1)? " + solution.canFinish(numCourses, prerequisites1));

        // Reset solution for next test
        solution = new CourseSchedule();
        System.out.println("Can finish courses (test 2)? " + solution.canFinish(numCourses, prerequisites2));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
            state.put(i, "U"); // U = unvisited
        }

        // Build adjacency list
        for (int[] req : prerequisites) {
            int fromNode = req[1];
            int toNode = req[0];
            adj.get(fromNode).add(toNode);
        }

        // DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (state.get(i).equals("U")) {
                dfs(i);
            }
            if (cycleFound) {
                return false;
            }
        }

        return true; // no cycle detected
    }

    private void dfs(int node) {
        if (state.get(node).equals("U")) {
            state.put(node, "V"); // visiting
            for (int nei : adj.get(node)) {
                dfs(nei);
            }
            state.put(node, "P"); // processed
        } else if (state.get(node).equals("V")) {
            cycleFound = true; // cycle detected
        }
    }
}
