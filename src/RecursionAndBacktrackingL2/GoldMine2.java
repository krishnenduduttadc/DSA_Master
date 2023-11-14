package RecursionAndBacktrackingL2;

import java.util.ArrayList;

public class GoldMine2 {
    static int max = 0;

    static void travel(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> bag){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0
                ||visited[i][j]==true){
            return;
        }
        visited[i][j]=true;
        bag.add(arr[i][j]);
        travel(arr,i-1,j,visited,bag);
        travel(arr,i,j+1,visited,bag);
        travel(arr,i,j-1,visited,bag);
        travel(arr,i+1,j,visited,bag);

    }
    public static void getMaxGold(int[][] arr){
        //write your code here
        boolean[][] visited=new boolean[arr.length][arr[0].length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0 && visited[i][j]==false){
                    ArrayList<Integer> bag = new ArrayList<Integer>();
                    travel(arr,i,j,visited,bag);

                    int sum=0;
                    for(int val:bag){
                        sum+=val;
                    }
                    if(sum>max){
                        max=sum;
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        int arr[][] = {
                {0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}
        };
        getMaxGold(arr);
        System.out.println(max);
    }
}

/*

6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
 */
