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
public class NextParen {

    public static void main(String[] args) {
        boolean p = nestParen("(((x))");
        System.out.println("" + p);
    }

    public static boolean nestParen(String str) {
       if(str.length() == 0)
        return true;

        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            return nestParen(str.substring(1,str.length()-1));
        }
        
        return false;
    }
}
