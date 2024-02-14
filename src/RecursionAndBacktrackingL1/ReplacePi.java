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
public class ReplacePi {

    public static void main(String[] args) {
        String s = "pippppiipiii";
        replacePi(s);
    }

    private static void replacePi(String s) {
        if (s.length() == 0) {
            return;
        } else {
            if (s.charAt(0) == 'p' && s.charAt(1) == 'i') {
                System.out.print("" + 3.14);
                replacePi(s.substring(2));
            } else {
                System.out.print("" + s.charAt(0));
                replacePi(s.substring(1));
            }
        }
    }
}
