package GraphL3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedundantConnection {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();


    public static void main(String[] args) {
        RedundantConnection solution = new RedundantConnection();

        // Example 1
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[] redundantEdge1 = solution.findRedundantConnection(edges1);
        System.out.println("Redundant edge in Example 1: " + Arrays.toString(redundantEdge1));

        // Example 2
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] redundantEdge2 = solution.findRedundantConnection(edges2);
        System.out.println("Redundant edge in Example 2: " + Arrays.toString(redundantEdge2));

        // Example 3
        int[][] edges3 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[] redundantEdge3 = solution.findRedundantConnection(edges3);
        System.out.println("Redundant edge in Example 3: " + Arrays.toString(redundantEdge3));
    }


    public boolean unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return false;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
        return true;
    }


    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            boolean flag = unionByRank(u, v);
            if (!flag) {
                return edge;
            }
        }
        return new int[2];
    }
}