package GraphL1;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {

    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class Pair {
        int v;
        String psf;

        Pair(int v, String psf){
            this.v = v;
            this.psf = psf;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr) {
        graph[src].add(new Edge(src, nbr));
        graph[nbr].add(new Edge(nbr, src));
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
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 5);
        addEdge(graph, 2, 4);

        int src = 0; // Source vertex

        // write your code here

        boolean[] visited = new boolean[vtces];
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(src, src + ""));

        while(st.size() > 0){
            Pair rem = st.pop();
            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "@" + rem.psf);
            for(Edge e: graph[rem.v]){
                if(visited[e.nbr] == false){
                    st.push(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }
}
