package Concepts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSDemo {
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        vis[0]=true;
        q.add(0);
        while(!q.isEmpty()){
            int f=q.poll();
            bfs.add(f);
            for(int n:adj.get(f)){
                if(vis[n]==false){
                    vis[n]=true;
                    q.add(n);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        BFSDemo sl = new BFSDemo();
        ArrayList < Integer > ans = sl.bfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
