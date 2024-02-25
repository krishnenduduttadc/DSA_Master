package GraphL1;

import java.util.ArrayList;

public class PerfectFriends {
    public static class Edge {
        int v;
        int n;
        Edge (int v, int n){
            this.v = v;
            this.n = n;
        }
    }


    public static void main(String[] args) throws Exception {
        // Statically define the number of students and friendships
        int n = 5; // Number of students
        int k = 4; // Number of friendships

        // write your code here
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int v = 0; v < n; v++) {
            graph[v] = new ArrayList<>();
        }

        // Statically define the friendships
        int[][] friendships = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        for (int[] friendship : friendships) {
            int v1 = friendship[0];
            int v2 = friendship[1];

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }


        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int v = 0; v < n; v++){
            if(visited[v] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndCreateComp(graph, v, comp, visited);
                comps.add(comp);
            }
        }

        int pairs = 0;

        for(int i = 0; i < comps.size(); i++){
            for(int j = i + 1; j < comps.size(); j++){
                int count = comps.get(i).size() * comps.get(j).size();
                pairs += count;
            }
        }

        System.out.println(pairs);
    }

    public static void drawTreeAndCreateComp(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);

        for(Edge e : graph[src]){
            if(visited[e.n] == false){
                drawTreeAndCreateComp(graph, e.n, comp, visited);
            }
        }
    }
}
