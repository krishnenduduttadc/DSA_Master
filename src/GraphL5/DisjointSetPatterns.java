package GraphL5;


import java.util.*;

public class DisjointSetPatterns {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSetPatterns(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public static void main(String[] args) {

        System.out.println("========== BASIC DSU ==========");

        DisjointSetPatterns ds = new DisjointSetPatterns(7);

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(5, 6);
        ds.unionByRank(6, 7);

        System.out.println("3 & 7 Same? " + ds.isConnected(3, 7));

        ds.unionByRank(3, 7);

        System.out.println("3 & 7 Same? " + ds.isConnected(3, 7));
        System.out.println("Component Size(1): " + ds.getComponentSize(1));
        System.out.println("Connected Components: " + ds.countDistinctParents(7));
        System.out.println("All Components: " + ds.getAllComponents(7));


        System.out.println("\n========== Make connected ==========");

        System.out.println(makeConnected(
                6,
                new int[][]{
                        {0, 1},
                        {0, 2},
                        {0, 3},
                        {1, 2},
                        {1, 3}
                }
        ));


        System.out.println("\n========== Find Redundant Connection ==========");

        System.out.println(Arrays.toString(
                findRedundantConnection(
                        new int[][]{
                                {1, 2},
                                {1, 3},
                                {2, 3}
                        }
                )
        ));


        System.out.println("\n========== Find Circle Number ==========");

        System.out.println(findCircleNum(
                new int[][]{
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }
        ));
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        DisjointSetPatterns ds = new DisjointSetPatterns(n);
        for (int[] edge : connections) {
            ds.unionByRank(edge[0], edge[1]);
        }
        // Count connected components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUPar(i) == i) {
                components++;
            }
        }
        return components - 1;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSetPatterns ds = new DisjointSetPatterns(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (ds.isConnected(u, v)) {
                return edge;
            }
            ds.unionByRank(u, v);
        }
        return new int[]{-1, -1};
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSetPatterns ds = new DisjointSetPatterns(n);
        // Connect all directly connected cities
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionByRank(i, j);
                }
            }
        }
        // Count provinces
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUPar(i) == i) {
                provinces++;
            }
        }
        return provinces;
    }

    public boolean isConnected(int u, int v) {
        return findUPar(u) == findUPar(v);
    }

    public int getComponentSize(int node) {
        int root = findUPar(node);
        return size.get(root);
    }

    public int countDistinctParents(int n) {
        Set<Integer> parents = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            parents.add(findUPar(i));
        }
        return parents.size();
    }

    public List<List<Integer>> getAllComponents(int n) {
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int parent = findUPar(i);
            components.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }
        return new ArrayList<>(components.values());
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

