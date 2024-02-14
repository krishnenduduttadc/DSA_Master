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
public class SubstringwithASCII {

    static void subseq(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        int code = ch;
        String ros = s.substring(1);
        subseq(ros, ans);
        subseq(ros, ans + ch);
        subseq(ros, ans + code);

    }

    public static void main(String[] args) {
        subseq("AB", "");
    }
}
