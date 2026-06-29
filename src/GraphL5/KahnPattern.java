package GraphL5;


import java.util.*;

public class KahnPattern {
    static int[] topoSort(int v, ArrayList<ArrayList<Pair>> adj) {
        int indegree[] = new int[v];
        for (int i = 0; i < v; i++) {
            for (Pair it : adj.get(i)) {
                indegree[it.first]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int topo[] = new int[v];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            for (Pair it : adj.get(node)) {
                indegree[it.first]--;
                if (indegree[it.first] == 0) {
                    q.add(it.first);
                }
            }
        }
        return topo;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(new Pair(3, 1));
        adj.get(3).add(new Pair(1, 1));
        adj.get(4).add(new Pair(0, 1));
        adj.get(4).add(new Pair(1, 1));
        adj.get(5).add(new Pair(0, 1));
        adj.get(5).add(new Pair(2, 1));

        int[] ans = KahnPattern.topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
        System.out.println("Can finish?" + canFinish(V, adj));
        System.out.println("Is cyclic?" + isCyclic(V, adj));
        System.out.println("Safe nodes?" + eventualSafeNodes(V, adj));
        System.out.println("Sequence Reconstruction? " + sequenceReconstruction(V, adj));
        System.out.println("Minimum semesters?" + minimumSemesters(V, adj));

        int[] time = {2, 4, 3, 5, 6, 7};
        System.out.println("Minimum time?" + minimumTime(V, adj, time));
    }

    static boolean canFinish(int V, ArrayList<ArrayList<Pair>> adj) {
        int[] indegree = new int[V];
        // Calculate indegree of every vertex
        for (int i = 0; i < V; i++) {
            for (Pair it : adj.get(i)) {
                indegree[it.first]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // Add all vertices having indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (Pair it : adj.get(node)) {
                indegree[it.first]--;
                if (indegree[it.first] == 0) {
                    q.offer(it.first);
                }
            }
        }
        // If all vertices are processed, no cycle exists
        return count == V;
    }

// LeetCode 2050 - Parallel Courses III
// Time Complexity : O(V + E)
// Space Complexity: O(V)

    static int minimumTime(int V, ArrayList<ArrayList<Pair>> adj, int[] time) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (Pair it : adj.get(i)) {
                indegree[it.first]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[V];
        // Courses with no prerequisites
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                dp[i] = time[i];
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Pair it : adj.get(node)) {
                dp[it.first] = Math.max(dp[it.first],
                        dp[node] + time[it.first]);
                indegree[it.first]--;
                if (indegree[it.first] == 0) {
                    q.offer(it.first);
                }
            }
        }
        int ans = 0;
        for (int t : dp)
            ans = Math.max(ans, t);
        return ans;
    }

    static int minimumSemesters(int V, ArrayList<ArrayList<Pair>> adj) {
        int[] indegree = new int[V];
        // Calculate indegree
        for (int i = 0; i < V; i++) {
            for (Pair it : adj.get(i)) {
                indegree[it.first]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // Courses that can be taken initially
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int semesters = 0;
        int completed = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            semesters++;
            while (size-- > 0) {
                int node = q.poll();
                completed++;
                for (Pair it : adj.get(node)) {
                    indegree[it.first]--;
                    if (indegree[it.first] == 0) {
                        q.offer(it.first);
                    }
                }
            }
        }
        return completed == V ? semesters : -1;
    }

    static boolean isCyclic(int V, ArrayList<ArrayList<Pair>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (Pair it : adj.get(i)) {
                indegree[it.first]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (Pair it : adj.get(node)) {
                indegree[it.first]--;
                if (indegree[it.first] == 0) {
                    q.offer(it.first);
                }
            }
        }
        return count != V;
    }

    static boolean sequenceReconstruction(int V, ArrayList<ArrayList<Pair>> adj) {
        int[] indegree = new int[V];
        // Calculate indegree
        for (int i = 0; i < V; i++) {
            for (Pair it : adj.get(i)) {
                indegree[it.first]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            // More than one choice => multiple topological orders
            if (q.size() > 1)
                return false;
            int node = q.poll();
            count++;
            for (Pair it : adj.get(node)) {
                indegree[it.first]--;
                if (indegree[it.first] == 0) {
                    q.offer(it.first);
                }
            }
        }
        return count == V;
    }

    static List<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Pair>> adj) {
        ArrayList<ArrayList<Pair>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (Pair it : adj.get(i)) {
                revAdj.get(it.first).add(new Pair(i, it.second));
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> safe = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safe.add(node);
            for (Pair it : revAdj.get(node)) {
                indegree[it.first]--;
                if (indegree[it.first] == 0) {
                    q.offer(it.first);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

