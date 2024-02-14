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
public class ReturnKeypad {

    private static String[] keypadnum(int n) {

        if (n == 0 || n == 1) {
            String[] ans = {""};
            return ans;
        } else if (n == 2) {
            String[] ans = {"a", "b", "c"};
            return ans;
        } else if (n == 3) {
            String[] ans = {"d", "e", "f"};
            return ans;
        } else if (n == 4) {
            String[] ans = {"g", "h", "i"};
            return ans;
        } else if (n == 5) {
            String[] ans = {"j", "k", "l"};
            return ans;
        } else if (n == 6) {
            String[] ans = {"m", "n", "o"};
            return ans;
        } else if (n == 7) {
            String[] ans = {"p", "q", "r", "s"};
            return ans;
        } else if (n == 8) {
            String[] ans = {"t", "u", "v"};
            return ans;
        } else if (n == 9) {
            String[] ans = {"w", "x", "y", "z"};
            return ans;
        }
        return null;
    }

    public static String[] keypad(int n) {

        if (n == 0) {
            String[] ans = {""};
            return ans;
        }
        String[] smallAns = keypad(n / 10);
        String[] choices = keypadnum(n % 10);
        String[] ans = new String[choices.length * smallAns.length];
        int k = 0;
        for (int i = 0; i < smallAns.length; i++) {
            for (int j = 0; j < choices.length; j++) {
                ans[k++] = smallAns[i] + choices[j];
            }
        }
        return ans;

    }

    public static void keypadk(int num) {

        printKeypad(num, "");

    }

    public static void printKeypad(int num, String output) {

        if (num == 0) {
            System.out.println(output);
            return;
        }
        String[] choices = keypadnum(num % 10);
        for (int i = 0; i < choices.length; i++) {
            printKeypad(num / 10, choices[i] + output);
        }

    }

    public static void main(String[] args) {
        keypadk(234);
    }
}
