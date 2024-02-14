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
public class EndX {

    public static void main(String[] args) {
        String p = endX("xxhixx");
        System.out.println("" + p);
    }

    public static String endX(String str) {
        if (str.length() == 1 || str.length() == 0) {
            return str;
        }
        
        String small=endX(str.substring(1));
        if(str.charAt(0)=='x'){
            return small+str.charAt(0);
        }else{
            return str.charAt(0)+small;
        }
    }
}
