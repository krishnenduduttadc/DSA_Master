package Concepts;

public class UnionFind {
    static int parent[];
    static void initialize() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if(x==parent[x]){
            return x;
        }else
            return find(parent[x]);
    }

    static void union(int x, int y) {
        int ulp_x=find(x);
        int ulp_y=find(y);
        if (ulp_x == ulp_y) {
            return;
        }
        parent[ulp_y]=ulp_x;
    }

    public static void main(String[] args) {
        int n = 5;

        parent = new int[5];
        initialize();
        union(0, 2);
        union(0, 4);
        System.out.println(find(4));
    }
}
