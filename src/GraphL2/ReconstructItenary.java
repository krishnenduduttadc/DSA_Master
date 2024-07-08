package GraphL2;

import java.util.*;

public class ReconstructItenary {
    static HashMap<String, PriorityQueue<String>> graph;
    static LinkedList<String> ans;

    public static List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        ans = new LinkedList<>();

        for (List<String> ticket : tickets) {
            PriorityQueue<String> temp = graph.getOrDefault(ticket.get(0), new PriorityQueue<>());
            temp.add(ticket.get(1));
            graph.put(ticket.get(0), temp);
        }

        dfs("JFK");
        return ans;
    }

    public static void main(String[] args) {
        // Hardcoded input
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

        List<String> res = findItinerary(tickets);
        System.out.println(res);
    }

    static void dfs(String src) {
        PriorityQueue<String> nbrs = graph.get(src);
        while (nbrs != null && nbrs.size() > 0) {
            String nbr = nbrs.remove();
            dfs(nbr);
        }
        ans.addFirst(src);
    }
}
