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
public class StrDist {
    
    public static void main(String[] args) {
        int p=strDist("catcowcat", "cat");
        System.out.println(""+p);
    }
    public static int strDist(String str, String sub) {
    if(str.length() < sub.length())
        return 0;
          
    if(str.substring(0, sub.length()).equals(sub) &&
        str.substring(str.length() - sub.length()).equals(sub))
        return str.length();
                        
    if(!str.substring(0, sub.length()).equals(sub))
        return strDist(str.substring(1), sub);
                                  
    return strDist(str.substring(0, str.length()-1), sub);
}
}
