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
public class Count11 {

    public static void main(String[] args) {
        int p = count11("abc11x11x11");
        System.out.println("" + p);
    }

    public static int count11(String str) {

        if (str.length() <2) {
            return 0;
        }
        int small=count11(str.substring(2));
        if(str.substring(0,2).equals("11")){
            return 1+small;
        }else{
            return count11(str.substring(1));
        }
        
    }
}
