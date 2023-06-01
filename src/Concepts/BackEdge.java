package Concepts;

import java.util.ArrayList;

public class BackEdge {
    static int V = 7;
    static ArrayList<Integer>[] al = new ArrayList[V];
    static boolean[] visited = new boolean[V+1];

    public static void main(String[] args) {


        // initializing
        for (int i = 0; i < al.length; i++) {
            al[i] = new ArrayList<Integer>();
        }

        // We can add any number of columns to each
        // rows as per our wish
        al[0].add(1);
        al[0].add(2);
        al[0].add(3);

        al[1].add(2);
        al[1].add(1);
        al[1].add(3);

        al[2].add(3);
        al[2].add(1);
        al[2].add(2);

        al[3].add(4);
        al[3].add(2);
        al[3].add(5);

        al[4].add(5);
        al[4].add(4);
        al[4].add(6);

        al[5].add(6);
        al[5].add(5);
        al[5].add(7);

        al[6].add(7);
        al[6].add(4);
        al[6].add(6);

//        for (int i = 0; i < V; i++) {
//            for (int j = 0; j < al[i].size(); j++) {
//                System.out.print(al[i].get(j) + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i <= V ; i++) {
            if(visited[i]==false){
                DFSR( i, 0);
            }
        }
    }

    private static void DFSR( int cur, int par) {
        System.out.println(cur + " ");
        visited[cur] = true;
        for (int nbr : al[cur]) {
            if (visited[nbr] == false) {
                DFSR( nbr, cur);
            } else if (nbr != par) {
                System.out.println(cur + "  " + nbr);
            }
        }
    }
}
