package GraphL1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumWireRequiredToConnectAllPC {
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

    public static class Pair implements Comparable<Pair> {
        int v;
        int av;
        int wt;

        Pair(int v, int av, int wt){
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(Pair o){
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) throws Exception {
        // Statically define the graph
        int vtces = 6; // Number of vertices
        int edges = 7; // Number of edges

        // Create the graph
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges statically
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 2, 3);
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 1, 3, 4);
        addEdge(graph, 2, 4, 5);
        addEdge(graph, 3, 4, 3);
        addEdge(graph, 3, 5, 2);

        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean[] visited = new boolean[vtces];

        while(pq.size() > 0){
            Pair rem = pq.remove();

            if(visited[rem.v] == true){
                continue;
            }

            visited[rem.v] = true;

            if(rem.av != -1){
                System.out.println("[" + rem.v + "-" + rem.av + "@" + rem.wt + "]");
            }

            for(Edge e : graph[rem.v]){
                if(visited[e.nbr] == false){
                    pq.add(new Pair(e.nbr, rem.v, e.wt));
                }
            }
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr, int wt) {
        graph[src].add(new Edge(src, nbr, wt));
        graph[nbr].add(new Edge(nbr, src, wt));
    }
}
