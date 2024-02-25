package GraphL1;

import java.util.ArrayList;

public class GetConnectedComponents {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        int vtces = 6; // Number of vertices
        int edges = 7; // Number of edges

        // Define the edge information statically
        int[][] edgeInfo = {
                {0, 1, 10},
                {0, 2, 10},
                {1, 2, 10},
                {2, 3, 10},
                {3, 4, 10},
                {4, 5, 10},
                {5, 3, 10}
        };

        // Create the graph
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        for (int[] info : edgeInfo) {
            int v1 = info[0];
            int v2 = info[1];
            int wt = info[2];
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        ArrayList<ArrayList<Integer>> cs = new ArrayList<>();

        // write your code here
        boolean[] visited = new boolean[vtces];
        for(int v = 0; v < vtces;v++){
            if(visited[v] == false){
                ArrayList<Integer> c = new ArrayList<>();
                d(graph, v, c, visited);
                cs.add(c);
            }
        }

        System.out.println(cs);
    }

    public static void d(ArrayList<Edge>[] graph, int src, ArrayList<Integer> c, boolean[] visited){
        visited[src] = true;
        c.add(src);
        for(Edge e: graph[src]){
            if(visited[e.nbr] == false){
                d(graph, e.nbr, c, visited);
            }
        }
    }
}
