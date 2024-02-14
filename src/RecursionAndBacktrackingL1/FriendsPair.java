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
public class FriendsPair {
    static int friendpairing(int n){
       if(n==0|| n==1 ||n==2){
            return n;
        }
    return friendpairing(n-1)+friendpairing(n-2)*(n-1);
    }
    public static void main(String[] args) {
        System.out.println(""+friendpairing(4));
    }
}
