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
public class BoardGame {

    static int countPath(int s, int e) {
        if (s == e) {
            return 1;
        }
        if (s > e) {
            return 0;
        }
        int cnt = 0;
        for (int i = 1; i <= 6; i++) {
            cnt += countPath(s + i, e);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countPath(0, 3));
    }
}
