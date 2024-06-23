package HML1;

import RecursionAndBacktrackingL1.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (List<Integer> row : wall) {
            int len = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                len += row.get(i);
                map.put(len, map.getOrDefault(len, 0) + 1);
                ans = Math.max(ans, map.get(len));
            }
        }
        return wall.size() - ans;
    }

    public static void main(String[] args) {
        BrickWall solution = new BrickWall();

        // Example usage:
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 1, 1));

        int minBricks = solution.leastBricks(wall);
        System.out.println("Minimum number of bricks to cross vertically: " + minBricks);
    }
}
