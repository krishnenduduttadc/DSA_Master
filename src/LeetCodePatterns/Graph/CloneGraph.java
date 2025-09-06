package LeetCodePatterns.Graph;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        // Build a small graph manually
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone graph
        Solution solution = new Solution();
        Node clonedGraph = solution.cloneGraph(node1);

        // Print results (BFS traversal of cloned graph)
        System.out.println("BFS traversal of cloned graph:");
        bfsPrint(clonedGraph);
    }

    private static void bfsPrint(Node start) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Node " + current.val + " neighbors: ");
            for (Node neighbor : current.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
            System.out.println();
        }
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class Solution {
        private Map<Node, Node> clonedNodes;

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            this.clonedNodes = new HashMap<>();
            return dfs(node);
        }

        private Node dfs(Node node) {
            if (clonedNodes.containsKey(node)) {
                return clonedNodes.get(node);
            }

            Node clonedNode = new Node(node.val);
            clonedNodes.put(node, clonedNode);

            for (Node neighbor : node.neighbors) {
                clonedNode.neighbors.add(dfs(neighbor));
            }

            return clonedNode;
        }
    }
}
