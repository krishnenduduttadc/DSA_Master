package GraphL3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraFormatted {
    static class Pair {
        int node;
        int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int V = 4, S = 2;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<>();
        inter1.add(new ArrayList<>() {{ add(1); add(1); }});
        inter1.add(new ArrayList<>() {{ add(2); add(6); }});
        adj.add(inter1);

        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<>();
        inter2.add(new ArrayList<>() {{ add(2); add(3); }});
        inter2.add(new ArrayList<>() {{ add(0); add(1); }});
        adj.add(inter2);

        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<>();
        inter3.add(new ArrayList<>() {{ add(1); add(3); }});
        inter3.add(new ArrayList<>() {{ add(0); add(6); }});
        adj.add(inter3);


        System.out.println("graph stands as.........");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i+" "+adj.get(i));
        }
        System.out.println("................");

        int[] res = dijkstra(V, adj, S);

        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e9;
        }
        dist[s] = 0;
        pq.add(new Pair(0, s));

        while (pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgewt = adj.get(node).get(i).get(1);

                if (dis + edgewt < dist[adjNode]) {
                    dist[adjNode] = dis + edgewt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }

            }
        }
        return dist;
    }
}
