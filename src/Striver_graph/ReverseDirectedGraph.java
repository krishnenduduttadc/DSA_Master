package Striver_graph;

import java.util.ArrayList;

public class ReverseDirectedGraph {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(3);
        adj.get(1).add(2);
        adj.get(3).add(4);
        adj.get(4).add(5);

        ArrayList<ArrayList<Integer>> reversedAdj = reverseDirectedGraph(adj, V);
        System.out.println(reversedAdj);

        for (int i = 1; i <= V; i++) {
            for (int j : reversedAdj.get(i)) {
                System.out.println(i + " -> " + j);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> reverseDirectedGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();
        for (int i = 0; i <=V ; i++) {
            reversedAdj.add(new ArrayList<>());
        }

        for (int i = 0; i <=V ; i++) {
            for (int j:adj.get(i)) {
                reversedAdj.get(j).add(i);
            }
        }
        return reversedAdj;
    }
}
