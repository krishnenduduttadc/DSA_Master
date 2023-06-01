package GraphL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BusRoutes {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));

    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        int n=routes.length;
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<routes[i].length;j++){
                int bustopno=routes[i][j];
                ArrayList<Integer> busno = map.getOrDefault(bustopno,new ArrayList<>());
                busno.add(i);
                map.put(bustopno,busno);
            }
        }

        LinkedList<Integer> q=new LinkedList<>();
        HashSet<Integer> busstopvis=new HashSet<>();
        HashSet<Integer> busvis=new HashSet<>();
        int level=0;
        q.addLast(S);
        busstopvis.add(S);


        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int rem=q.removeFirst();
                if(rem==T){
                    return level;
                }

                ArrayList<Integer> buses = map.get(rem);
                for(int bus:buses){
                    if(busvis.contains(bus)==true){
                        continue;
                    }

                    int[] arr=routes[bus];
                    for(int busstop:arr){
                        if(busstopvis.contains(busstop)==true){
                            continue;
                        }

                        q.addLast(busstop);
                        busstopvis.add(busstop);
                    }
                    busvis.add(bus);
                }
            }
            level++;
        }
        return -1;

    }
}

/*
2
3
1 2 7
3 6 7
1 6
 */
