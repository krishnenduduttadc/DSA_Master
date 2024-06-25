package GraphL2;

public class GraphDSU_1 {

    int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges

    static class Edge {
        public int src, dest;
    }

    GraphDSU_1(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(int i, int parent[]) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent[i], parent);
    }

    //Union
    void union(int x, int y, int parent[]) {
        int s1 = find(x, parent);
        int s2 = find(y, parent);
        if (s1 != s2) {
            parent[s1] = s2;
        }
    }

    int isCycle(GraphDSU_1 graph) {
        //DSU Logic to check if graph contains cycle or not
        int parent[] = new int[graph.V];
        for (int i = 0; i < graph.V; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < graph.E; i++) {
            int x = graph.find(graph.edge[i].src, parent);
            int y = graph.find(graph.edge[i].dest, parent);
            if (x == y) {
                return 1;
            }
            graph.union(x, y, parent);
        }

        return 0;
    }

    public static void main(String[] args) {
        /* Let us create the following graph
        0
        | \
        |  \
        1---2 */
        int V = 3, E = 3;
        GraphDSU_1 graph = new GraphDSU_1(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph) == 1)
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }

}
