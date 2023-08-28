/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP1;

/**
 *
 * @author krish
 */
public class Test {
    public static void main(String[] args) {
         int grid[][] = {
            {8, 2, 1, 6},
            {6, 5, 5, 2},
            {2, 1, 0, 3},
            {7, 2, 2, 4},
            {1, 0, 0, 1}
        };
         
//         for (int i = grid.length - 1; i >= 0; i--) {
//            for (int j = grid[0].length - 1; j >= 0; j--) {
//                System.out.print(" "+grid[i][j]);
//            }
//             System.out.println("");                    
//         }
         
         
//         for (int i = 0; i <grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                System.out.print(" "+grid[i][j]);
//            }
//             System.out.println("");                    
//         }
         
//         for (int i = 0; i <grid[0].length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                System.out.print(" "+grid[i][j]);
//            }
//             System.out.println("");
//         }

        int arr[]={5,4,6,7,3,2,9};
        for (int i = 0; i < arr.length; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                if(max<arr[j]){
                    max=arr[j];
                }
                System.out.print(arr[j]+" ");
            }
            System.out.print("# "+max+" is maximum");
            System.out.println();
        }
    }
}
