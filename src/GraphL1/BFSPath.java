package GraphL1;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BFSPath {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair{
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }
    static void addEdge(ArrayList<Edge>[] graph, int v1, int v2) {
        graph[v1].add(new Edge(v1, v2));
        graph[v2].add(new Edge(v2, v1));
    }

    public static void main(String[] args) throws Exception {
        int vtces = 7;
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = 8;
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 0, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 4, 6);
        int src=0;

        ArrayDeque<Pair> q=new ArrayDeque<>();
        boolean[] visited = new boolean[vtces];
        q.add(new Pair(src,src+""));
        while(!q.isEmpty()){
            Pair rem=q.removeFirst();
            if(visited[rem.v]==true){
                continue;
            }
            visited[rem.v]=true;
            System.out.println(rem.v+" "+rem.psf);
            for(Edge e:graph[rem.v]){
                q.add(new Pair(e.nbr,rem.psf+e.nbr));
            }
        }
    }
    }
