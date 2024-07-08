package GraphL2;

public class RedundantConnection {
    public static void main(String[] args) {
        // Hardcoded input
        int[][] pos = {
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int[] ans = findRedundantConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        // Initialization of parent and rank arrays
        for (int i = 1; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        // Applying union-find algorithm
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int lu = find(par, u);
            int lv = find(par, v);

            if (lu != lv) {
                if (rank[lu] > rank[lv]) {
                    par[lv] = lu;
                } else if (rank[lu] < rank[lv]) {
                    par[lu] = lv;
                } else {
                    par[lu] = lv;
                    rank[lv]++;
                }
            } else {
                return edge;
            }
        }
        return new int[2];
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        int temp = find(parent, parent[x]);
        parent[x] = temp;
        return temp;
    }
}
