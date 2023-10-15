package ArraysL2;

import java.util.ArrayList;

public class BestMeetingPoint {
    public static int minTotalDistance(int[][] grid) {
        // Write your code here
        ArrayList<Integer> xcord = new ArrayList<>();
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    xcord.add(r);
                }
            }
        }

        ArrayList<Integer> ycord = new ArrayList<>();
        for(int c = 0; c < grid[0].length; c++){
            for(int r = 0; r < grid.length; r++){
                if(grid[r][c] == 1){
                    ycord.add(c);
                }
            }
        }

        int x = xcord.get(xcord.size() / 2);
        int y = ycord.get(ycord.size() / 2);

        int dist = 0;

        for(int xval: xcord){
            dist += Math.abs(x - xval);
        }

        for(int yval : ycord){
            dist += Math.abs(y - yval);
        }

        return dist;


    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {

        int[][] grid = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0},
        };

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}
