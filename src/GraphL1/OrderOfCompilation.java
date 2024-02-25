package GraphL1;

import java.util.ArrayList;
import java.util.Stack;

public class OrderOfCompilation {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        // Statically define the graph
        int vtces = 6; // Number of vertices
        int edges = 6; // Number of edges

        // Create the graph
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges statically
        addEdge(graph, 5, 2);
        addEdge(graph, 5, 0);
        addEdge(graph, 4, 0);
        addEdge(graph, 4, 1);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);

        // write your code here
        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for(int v = 0; v < vtces; v++){
            if(visited[v] == false){
                topologicalSort(graph, v, visited, st);
            }
        }

        while(st.size() > 0){
            System.out.println(st.pop());
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr) {
        graph[src].add(new Edge(src, nbr));
    }


    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st){
        visited[src] = true;
        for(Edge e: graph[src]){
            if(visited[e.nbr] == false){
                topologicalSort(graph, e.nbr, visited, st);
            }
        }

        st.push(src);
    }

}
