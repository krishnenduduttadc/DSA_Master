/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

/**
 *
 * @author krish
 */
public class ReturnSubsets {

    public static void main(String[] args) {
        int arr[] = {15, 20, 12};
        int[][] ll=subsets(arr, 0);
        for (int i = 0; i < ll.length; i++) {
            for (int j = 0; j < ll[i].length; j++) {
                System.out.print(" "+ll[i][j]);
            }System.out.println("");
        }
    }

    public static int[][] subsets(int input[], int start) {

        if (start == input.length - 1) {
            int output[][] = new int[1][1];
            output[0][0] = input[start];
            return output;
        }

        int smallAns[][] = subsets(input, start + 1);
        int ans[][] = new int[2 * smallAns.length + 1][];
        for (int i = 0; i < smallAns.length; i++) {
            ans[i] = new int[smallAns[i].length];

        }

        ans[smallAns.length] = new int[1];
        int y = 0;
        for (int i = smallAns.length + 1; i < ans.length; i++) {
            ans[i] = new int[smallAns[y++].length + 1];
        }

        for (int i = 0; i < smallAns.length; i++) {
            for (int j = 0; j < smallAns[i].length; j++) {
                ans[i][j] = smallAns[i][j];
            }
        }
        int x = smallAns.length;
        ans[x++][0] = input[start];
        for (int i = 0; i < smallAns.length; i++) {
            ans[x][0] = input[start];
            for (int j = 0; j < smallAns[i].length; j++) {
                ans[x][j + 1] = smallAns[i][j];
            }
            x++;
        }
        return ans;
    }

}
