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
public class Tile {
    static int tilingways(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return tilingways(n-1)+tilingways(n-2);
    }
    public static void main(String[] args) {
        System.out.println(""+tilingways(4));
    }
}
