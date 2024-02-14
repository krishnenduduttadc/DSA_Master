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
public class ReverseStr {

    public static void main(String[] args) {
        String aa = "binod";
        rev(aa, aa.length());
        System.out.println("\n------------");
        
        rev2(aa);
    }

    static void rev(String str, int n) {
        if (n == 0) {
            return;
        } else {           
            System.out.print("" + str.charAt(n-1));
            rev(str, n - 1);
        }
    }
    
    static void rev2(String str) {

        if (str.length() == 0) {
            return;
        } else {           
            String ros=str.substring(1);
            rev2(ros);
            System.out.print("" + str.charAt(0));

        }
    }
}
