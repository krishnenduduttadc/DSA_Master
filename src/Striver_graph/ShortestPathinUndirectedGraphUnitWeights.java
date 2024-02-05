package Striver_graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinUndirectedGraphUnitWeights {

    public static void main(String[] args) throws IOException {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        ShortestPathinUndirectedGraphUnitWeights obj = new ShortestPathinUndirectedGraphUnitWeights();
        int res[] = obj.shortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    public int[] shortestPath(int[][] edges,int n,int m ,int s) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int dist[] = new int[n];
        for(int i = 0;i<n;i++) dist[i] = (int)1e9;
        dist[s]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(int it:adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it]=1+dist[node];
                    q.add(it);
                }
            }
        }

        for(int i = 0;i<n;i++) {
            if(dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}