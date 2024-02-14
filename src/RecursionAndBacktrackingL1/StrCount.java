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
public class StrCount {

    public static void main(String[] args) {
        int p = strCount("catcowcat", "dog");
        System.out.println("" + p);
    }

    public static int strCount(String str, String sub) {

        if(str.length()<sub.length()){
            return 0;
        }
        
        if(str.substring(0,sub.length()).equals(sub)){
            return 1+strCount(str.substring(sub.length()),sub);
        }
        else{
            return strCount(str.substring(1),sub);
        }
    }

}
