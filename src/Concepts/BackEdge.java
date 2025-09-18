package Concepts;

import java.util.ArrayList;

public class BackEdge {
    static int V = 7;                      // vertices are 0..6
    static ArrayList<Integer>[] al = new ArrayList[V];
    static boolean[] visited = new boolean[V];

    public static void main(String[] args) {

        // initialize adjacency lists for 0..V-1
        for (int i = 0; i < V; i++) {
            al[i] = new ArrayList<>();
        }

        // --- Example edges (0-based) ---
        // adjust these to match the exact graph you want
        al[0].add(1);
        al[0].add(2);
        al[0].add(3);

        al[1].add(2);
        al[1].add(3);

        al[2].add(3);
        al[2].add(1);

        al[3].add(4);
        al[3].add(2);
        al[3].add(5);

        al[4].add(5);
        al[4].add(6);

        al[5].add(6);
        al[5].add(4);

        al[6].add(4);
        al[6].add(5);

        // DFS for all components (0..V-1)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSR(i, -1);   // -1 means "no parent" (root)
            }
        }
    }

    private static void DFSR(int cur, int par) {
        System.out.println("visit: " + cur);
        visited[cur] = true;
        for (int nbr : al[cur]) {
            if (!visited[nbr]) {
                DFSR(nbr, cur);
            } else if (nbr != par) {
                // found a back-edge in an undirected-style graph
                System.out.println("back-edge: " + cur + " -> " + nbr);
            }
        }
    }
}
