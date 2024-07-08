package GraphL2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BusRoutes {
    public static void main(String[] args) {
        // Hardcoded input values
        int n = 2; // number of routes
        int m = 3; // number of stops in each route
        int[][] routes = {
                {1, 2, 7},
                {3, 6, 7}
        };
        int src = 1; // source bus stop
        int dest = 6; // destination bus stop

        System.out.println(numBusesToDestination(routes, src, dest));
    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        int n = routes.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Building a map of bus stops to their respective bus routes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int busStopNo = routes[i][j];
                ArrayList<Integer> busNos = map.getOrDefault(busStopNo, new ArrayList<>());
                busNos.add(i);
                map.put(busStopNo, busNos);
            }
        }

        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> busStopVisited = new HashSet<>();
        HashSet<Integer> busVisited = new HashSet<>();
        int level = 0;
        q.addLast(S);
        busStopVisited.add(S);

        // Performing BFS to find the minimum number of buses
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int currentStop = q.removeFirst();
                if (currentStop == T) {
                    return level;
                }

                ArrayList<Integer> buses = map.get(currentStop);
                if (buses != null) {
                    for (int bus : buses) {
                        if (busVisited.contains(bus)) {
                            continue;
                        }

                        int[] busRoute = routes[bus];
                        for (int nextStop : busRoute) {
                            if (busStopVisited.contains(nextStop)) {
                                continue;
                            }

                            q.addLast(nextStop);
                            busStopVisited.add(nextStop);
                        }
                        busVisited.add(bus);
                    }
                }
            }
            level++;
        }
        return -1; // If destination is not reachable
    }
}
