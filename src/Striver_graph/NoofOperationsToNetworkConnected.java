package Striver_graph;

import java.util.ArrayList;
import java.util.List;


class NoofOperationsToNetworkConnected {
    private List<Integer> rank;
    private List<Integer> parent;
    private List<Integer> size;

    public NoofOperationsToNetworkConnected(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    private int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    private void unionByRank(int u, int v) {
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

    private void unionBySize(int u, int v) {
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

    public int solve(int n, int[][] edge) {
        int cntExtras = 0;
        int m = edge.length;

        for (int i = 0; i < m; i++) {
            int u = edge[i][0];
            int v = edge[i][1];

            if (findUPar(u) == findUPar(v)) {
                cntExtras++;
            } else {
                unionBySize(u, v);
            }
        }

        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if (parent.get(i) == i) cntC++;
        }

        int ans = cntC - 1;

        if (cntExtras >= ans) return ans;
        return -1;
    }

    public static void main(String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        NoofOperationsToNetworkConnected obj = new NoofOperationsToNetworkConnected(V);
        int ans = obj.solve(V, edge);

        System.out.println("The number of operations needed: " + ans);
    }
}