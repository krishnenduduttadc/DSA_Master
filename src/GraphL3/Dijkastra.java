package GraphL3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkastra {
    static class Pair {
        int node;
        int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
        int V = 3, E = 3, S = 2;
        ArrayList<Integer> node1 = new ArrayList<>();
        node1.add(1);
        node1.add(1);

        ArrayList<Integer> node2 = new ArrayList<>();
        node2.add(2);
        node2.add(6);

        ArrayList<Integer> node3 = new ArrayList<>();
        node3.add(2);
        node3.add(3);

        ArrayList<Integer> node4 = new ArrayList<>();
        node4.add(0);
        node4.add(1);

        ArrayList<Integer> node5 = new ArrayList<>();
        node5.add(1);
        node5.add(3);

        ArrayList<Integer> node6 = new ArrayList<>();
        node6.add(0);
        node6.add(6);

        // Initialize inter1, inter2, inter3
        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<>();
        inter1.add(node1);
        inter1.add(node2);

        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<>();
        inter2.add(node3);
        inter2.add(node4);

        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<>();
        inter3.add(node5);
        inter3.add(node6);

        // Initialize adj
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        adj.add(inter1); // for 1st node
        adj.add(inter2); // for 2nd node
        adj.add(inter3); // for 3rd node
        System.out.println(adj);

        int[] res = dijkstra(V, adj, S);

        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }


    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        PriorityQueue<Pair> pq =
                new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int) (1e9);
        dist[s]=0;
        pq.add(new Pair(s,0));

        while (pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            // Check for all adjacent nodes of the popped-out
            for (int i = 0; i < adj.get(node).size(); i++) {

                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}