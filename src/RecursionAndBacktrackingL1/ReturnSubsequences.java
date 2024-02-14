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
public class ReturnSubsequences {

    static String[] subseq(String str) {
        if (str.length() == 0) {
            return new String[]{""};
        }

        String[] smallAns = subseq(str.substring(1));
        String[] ans = new String[2 * smallAns.length];

        for (int i = 0; i < smallAns.length; i++) {
            ans[i] = smallAns[i];
        }
        for (int i = 0; i < smallAns.length; i++) {
            ans[i + smallAns.length] = str.charAt(0) + smallAns[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        String res[] = subseq("abc");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]+" ");
        }
    }

}
