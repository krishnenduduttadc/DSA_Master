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
public class Xtolast {
    static String moveallX(String s){
        if(s.length()==0){
            return "";
        }
        char ch=s.charAt(0);
        String ans=moveallX(s.substring(1));
        if(ch=='X'){
            return ans+ch;
        }
        return ch+ans;
    }
    public static void main(String[] args) {
        System.out.println(""+moveallX("AABXCVBXXG"));
    }
 
}
