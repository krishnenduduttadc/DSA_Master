package GraphL1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {
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
    static class Pair implements Comparable<Pair> {

        int v;
        int av;
        int wt;

        Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    static void addEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt) {
        graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
    }

    public static void main(String[] args) throws Exception {
        int vtces = 7;
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = 8;

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 10);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 5, 6, 3);
        addEdge(graph, 4, 6, 8);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));
        boolean[] visited = new boolean[vtces];
        while(pq.size()>0){
            Pair rem=pq.remove();
            if(visited[rem.v]==true){
                continue;
            }
            visited[rem.v]=true;
            if (rem.av != -1) {
                System.out.println(rem.v+"-"+rem.av+"@"+rem.wt);
            }
            for(Edge e:graph[rem.v]){
                if(visited[e.nbr]==false){
                    pq.add(new Pair(e.nbr,rem.v,e.wt));
                }
            }
        }
    }


}
