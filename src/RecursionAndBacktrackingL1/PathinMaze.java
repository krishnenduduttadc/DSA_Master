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
public class PathinMaze {
    
     static int countPathMaze(int n, int i,int j) {
         if(i==n-1 && j==n-1){
             return 1;
         }
         if(i>=n || j>=n){
             return 0;
         }
         
         return countPathMaze(n,i+1,j)+countPathMaze(n,i,j+1);
     }
    public static void main(String[] args) {
        System.out.println(countPathMaze(3,0,0));
    }
}
