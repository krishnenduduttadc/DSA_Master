package GraphL3;

import java.util.*;

public class TerminalNodes {
    private Map<Integer, List<Integer>> adjacencyList;

    public TerminalNodes() {
        adjacencyList = new HashMap<>();
    }

    public static void main(String[] args) {
        TerminalNodes graph = new TerminalNodes();

        // Adding edges to the graph
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);

        graph.printTerminalNodes();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(destination);
    }

    public void printTerminalNodes() {
        Set<Integer> nodesWithOutgoingEdges = adjacencyList.keySet();
        Set<Integer> allNodes = new HashSet<>();

        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            allNodes.add(entry.getKey());
            allNodes.addAll(entry.getValue());
        }
        List<Integer> terminalNodes = new ArrayList<>();
        // Terminal nodes = allNodes - nodesWithOutgoingEdges
        for (int node : allNodes) {
            if (!nodesWithOutgoingEdges.contains(node)) {
                terminalNodes.add(node);
            }
        }
        System.out.println("Terminal Nodes:");
        for (int node : terminalNodes) {
            System.out.println(node);
        }
    }
}
