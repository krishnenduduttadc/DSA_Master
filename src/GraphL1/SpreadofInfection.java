package GraphL1;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SpreadofInfection {
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

    static class Pair {

        int v;
        int time;

        Pair(int v, int time) {
            this.v = v;
            this.time = time;
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
            graph[i] = new ArrayList<>(0);
        }
        int edges = 8;
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 3, 4, 10);
        addEdge(graph, 4, 5, 10);
        addEdge(graph, 5, 6, 10);
        addEdge(graph, 4, 6, 10);

        int src = 6;
        int t = 3;

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 1));
        int[] visited = new int[vtces];
        int count = 0;

        while(q.size()>0){
            Pair rem=q.removeFirst();
            if(visited[rem.v]>0){
                continue;
            }
            visited[rem.v]=rem.time;
            if(rem.time>t){
                break;
            }
            count++;
            for(Edge e:graph[rem.v]){
                if(visited[e.nbr]==0){
                    q.add(new Pair(e.nbr,rem.time+1));
                }
            }
        }

        System.out.println(count);
    }
}
