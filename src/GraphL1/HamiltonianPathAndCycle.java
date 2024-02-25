package GraphL1;

import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPathAndCycle {
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
        // Input graph statically
        int vtces = 6; // Number of vertices
        int edges = 7; // Number of edges

        // Create graph
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
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 2, 4, 3);

        int src = 0; // Source vertex

        // Perform Hamiltonian path and cycle calculation
        HashSet<Integer> visited = new HashSet<>();
        h(graph, src, visited, src + "", src);
    }

    public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr, int wt) {
        graph[src].add(new Edge(src, nbr, wt));
        graph[nbr].add(new Edge(nbr, src, wt));
    }
    public static void h(ArrayList<Edge>[] graph, int src, HashSet<Integer> v, String psf, int osrc){
        if(v.size() == graph.length - 1){
            System.out.print(psf);

            boolean cl = false;
            for(Edge e: graph[src]){
                if(e.nbr == osrc){
                    cl = true;
                    break;
                }
            }

            if(cl == true){
                System.out.println("*");
            } else {
                System.out.println(".");
            }

            return;
        }

        v.add(src);
        for(Edge e : graph[src]){
            if(v.contains(e.nbr) == false){
                h(graph, e.nbr, v, psf + e.nbr, osrc);
            }
        }

        v.remove(src);
    }
}
