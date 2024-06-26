package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleUndirectedBFS {

    static class Node {
        int first;
        int second;
        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
                                 boolean vis[], int parent[])
    {
        Queue<Node> q =  new LinkedList<>(); //BFS
        q.add(new Node(s, -1));
        vis[s] =true;

        // until the queue is empty
        while(!q.isEmpty())
        {
            // source node and its parent node
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // go to all the adjacent nodes
            for(Integer it: adj.get(node))
            {
                if(vis[it]==false)
                {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }

                // if adjacent node is visited and is not its own parent node
                else if(it!=par) return true;
            }
        }

        return false;
    }

    // function to detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        int parent[] = new int[V];
        Arrays.fill(parent,-1);

        for(int i=0;i<V;i++)
            if(vis[i]==false)
                if(checkForCycle(adj, i,vis, parent))
                    return true;

        return false;
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println(adj);

        CycleUndirectedBFS obj = new CycleUndirectedBFS();
        boolean ans = obj.isCycle(4, adj);
        if (ans==true){
            System.out.println("cycle exists");
            return;
        }
        else
            System.out.println("cycle does not exist");
    }
}


