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
public class StringClean {

    public static void main(String[] args) {
        String p = stringClean("abbbcdd");
        System.out.println("" + p);
    }

    public static String stringClean(String str) {
        
        if(str.length()==1){
            return str;
        }
        
        String small=stringClean(str.substring(1));
        if(str.charAt(0)==small.charAt(0)){
            return str.charAt(0)+small.substring(1);
        }else{
            return str.charAt(0)+small;
        }
        
    }
}
