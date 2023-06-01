package Striver_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



class Pair6{
    int first;
    int second;
    public Pair6(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple2 {
    int first, second, third;
    Tuple2(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class CheapestFlights {
    public int CheapestFLight(int n,int flights[][],int src,int dst,int K) {

        // Create the adjacency list to depict airports and flights in
        // the form of a graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        // Create a queue which stores the node and their distances from the
        // source in the form of {stops, {node, dist}} with ‘stops’ indicating
        // the no. of nodes between src and current node.
        Queue<Tuple2> q = new LinkedList<>();

        q.add(new Tuple2(0, src, 0));

        // Distance array to store the updated distances from the source.
        int[] dist = new int[n];
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;

        // Iterate through the graph using a queue like in Dijkstra with
        // popping out the element with min stops first.
        while(!q.isEmpty()) {
            Tuple2 it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            // We stop the process as soon as the limit for the stops reaches.
            if(stops > K) continue;
            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple2(stops + 1, adjNode, cost + edW));
                }
            }
        }
        // If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}

class tuf4 {

    public static void main(String[] args) {

        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        CheapestFlights obj = new CheapestFlights();
        int ans = obj.CheapestFLight(n,flights,src,dst,K);

        System.out.print(ans);
        System.out.println();
    }
}
