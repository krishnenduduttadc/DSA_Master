package GraphL1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ShortestPathinWeights {
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
        // Statically define the graph
        int vtces = 6; // Number of vertices
        int edges = 8; // Number of edges

        // Create the graph
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges statically
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 10);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 2, 4, 3);
        addEdge(graph, 4, 1, 5);

        int src = 0; // Source vertex

        // write your code here

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src + "", 0));
        boolean[] visited = new boolean[vtces];

        while(pq.size() > 0){
            Pair rem = pq.remove();

            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;

            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

            for(Edge e: graph[rem.v]){
                if(visited[e.nbr] == false){
                    pq.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }

    }

    public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr, int wt) {
        graph[src].add(new Edge(src, nbr, wt));
        graph[nbr].add(new Edge(nbr, src, wt));
    }

    public static class Pair implements Comparable<Pair> {
        int v;
        String psf;
        int wsf;

        Pair(int v, String psf, int wsf){
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
}
