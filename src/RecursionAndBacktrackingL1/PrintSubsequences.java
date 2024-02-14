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
public class PrintSubsequences {
    static void subseq(String str, String resSoFar) {
        if (str.length() == 0) {
            System.out.println(resSoFar+"");
            return;
        }
        subseq(str.substring(1),resSoFar);
        subseq(str.substring(1),resSoFar+str.charAt(0));
    }
    static void subseq(String str) {
        subseq(str,"");
    }
    public static void main(String[] args) {
        subseq("abc");
    }
    
}
