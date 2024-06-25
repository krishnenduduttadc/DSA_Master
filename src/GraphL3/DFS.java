package GraphL3;

import java.util.ArrayList;

class DFS {

    public static void main(String args[]) {
        int V = 5;
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ls = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if(vis[i]==false){
                ArrayList<Integer> ress = new ArrayList<>();
                ress=dfs(i, vis, adj, ls);
                res.add(ress);
            }
        }
        System.out.println(res);
    }


    public static ArrayList<Integer> dfs(int s, boolean vis[], ArrayList<ArrayList<Integer>> adj,
                                         ArrayList<Integer> ls) {
        vis[s] = true;
        ls.add(s);
        for (int it : adj.get(s)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, ls);
            }
        }
        return ls;
    }
}
