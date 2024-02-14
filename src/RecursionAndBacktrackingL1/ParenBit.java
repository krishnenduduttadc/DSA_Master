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
public class ParenBit {

    public static void main(String[] args) {
        String p = parenBit("xyz(abc)123");
        System.out.println("" + p);
    }

    public static String parenBit(String str) {
        if(str.charAt(0) == '(' && str.charAt(str.length()-1) == ')')
        return str;

        
        
        if(str.charAt(0)=='('){
            return parenBit(str.substring(0, str.length() - 1));
        }
        if(str.charAt(str.length()-1)==')'){
            return parenBit(str.substring(1));
        }
        return parenBit(str.substring(1, str.length() - 1));
    }

}
