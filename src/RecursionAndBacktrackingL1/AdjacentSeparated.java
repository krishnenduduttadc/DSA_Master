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
public class AdjacentSeparated {

    public static void main(String[] args) {
        String p = allStar("hello");
        System.out.println("" + p);
    }

//    public static String allStar(String str) {
//        return allStar(str);
//    }
    
    public static String allStar(String str) {
        if(str.length()==1 || str.length()==0){
            return str;
        }
        
        String small=allStar(str.substring(1));
        return str.charAt(0)+"*"+small;
    }
}
