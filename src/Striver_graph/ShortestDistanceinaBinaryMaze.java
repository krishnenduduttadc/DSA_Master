package Striver_graph;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceinaBinaryMaze {

    static class Pair {
        int x, y;

        Pair(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }

    private boolean isValid(int x, int y, int rows, int cols, int[][] maze, boolean[][] visited) {
        return x >= 0 && x < rows && y >= 0 && y < cols && maze[x][y] == 1 && !visited[x][y];
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] distance = new int[rows][cols];

        queue.offer(new Pair(start[0], start[1]));
        visited[start[0]][start[1]] = true;
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            for (int[] dir : directions) {
                int newX = current.x;
                int newY = current.y;
                int steps = 0;

                while (isValid(newX + dir[0], newY + dir[1], rows, cols, maze, visited)) {
                    newX += dir[0];
                    newY += dir[1];
                    steps++;
                }

                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new Pair(newX, newY));
                    distance[newX][newY] = distance[current.x][current.y] + steps;
                }
            }
        }

        return (visited[destination[0]][destination[1]]) ? distance[destination[0]][destination[1]] : -1;
    }

    public static void main(String[] args) throws IOException {
        int[][] maze = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        };

        int[] start = {0, 0};
        int[] destination = {4, 4};

        ShortestDistanceinaBinaryMaze distanceFinder = new ShortestDistanceinaBinaryMaze();
        int result = distanceFinder.shortestDistance(maze, start, destination);

        System.out.println("Shortest Distance: " + result);
    }
}
