package GraphL3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TerminalNodes {
    private Map<Integer, List<Integer>> adjacencyList;

    public TerminalNodes() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(destination);
    }

    public void printTerminalNodes() {
        List<Integer> terminalNodes = new ArrayList<>();
        for (int node : adjacencyList.keySet()) {
            if (adjacencyList.get(node).isEmpty()) {
                terminalNodes.add(node);
            }
        }
        System.out.println("Terminal Nodes:");
        for (int node : terminalNodes) {
            System.out.println(node);
        }
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
}
