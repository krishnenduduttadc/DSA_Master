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
public class WordsfromPhoneDigits {

    static String keypadArr[] = {"", "", "abc", "def", "ghi", "jkl", "mno"};

    static void keypad(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        String code = keypadArr[ch - '0'];
        String ros = s.substring(1);

        for (int i = 0; i < code.length(); i++) {
            keypad(ros, ans + code.charAt(i));
        }
    }

    public static void main(String[] args) {
        keypad("23", "");
    }
}
