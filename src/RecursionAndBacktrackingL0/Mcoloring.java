package RecursionAndBacktrackingL0;

public class Mcoloring {

    public static void main(String[] args) {
        Mcoloring obj = new Mcoloring();

        // Example graph with 4 vertices
        boolean[][] graph = {
                {false, true, true, true},
                {true, false, true, false},
                {true, true, false, true},
                {true, false, true, false}
        };

        int m = 3; // Number of colors
        int n = 4; // Number of vertices

        boolean result = obj.graphColoring(graph, m, n);

        System.out.println("Is it possible to color the graph using " + m + " colors?");
        System.out.println(result ? "Yes" : "No");
    }

    public boolean isSafe(boolean[][] graph, int[] color, int currColor, int r) {
        for (int c = 0; c < graph.length; c++) {
            if (graph[r][c] && color[c] == currColor) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(boolean[][] graph, int[] color, int m, int r) {
        if (r == graph.length) return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(graph, color, i, r)) {
                color[r] = i;
                if (dfs(graph, color, m, r + 1)) return true;
                color[r] = 0;
            }
        }

        return false;
    }

    public boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color = new int[n];
        return dfs(graph, color, m, 0);
    }
}
