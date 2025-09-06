package LeetCodePatterns.DSU;

public class DisjointSet {
    int[] parent;
    int[] rank;

    DisjointSet(int n) {
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(5);
        System.out.println(disjointSet.isSame(2, 4));
        disjointSet.merge(2, 4);
        System.out.println(disjointSet.isSame(2, 4));
    }

    int findLeader(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            int leader = findLeader(parent[x]);
            parent[x] = leader;
            return leader;
        }
    }

    boolean isSame(int x, int y) {
        return findLeader(x) == findLeader(y);
    }

    public void merge(int x, int y) {
        int xleader = findLeader(x);
        int yleader = findLeader(y);
        if (xleader != yleader) {
            if (rank[xleader] < rank[yleader]) {
                parent[xleader] = yleader;
            } else {
                parent[yleader] = xleader;
                if (rank[xleader] == rank[yleader]) {
                    rank[xleader] += 1;
                }
            }
        }
    }
}
