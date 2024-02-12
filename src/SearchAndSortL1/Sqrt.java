/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSortL1;

/**
 *
 * @author krish
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(37));
    }

    private static int sqrt(int x) {
        int low = 1, high = x,ans=0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int mSqr = mid * mid;
            if (mSqr == x) {
                return mid;
            } else if (mSqr > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

}
