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
public class ReturnAllCodes {

    public static void main(String[] args) {
        String input = "1123";
        String output[] = getCode(input);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static String[] getCode(String input) {
        // Write your code here

        if (input.length() == 0) {
            String[] ap = new String[1];
            ap[0] = "";
            return ap;
        }
        String[] out1 = getCode(input.substring(1));
        String[] out2 = new String[0];

        int f = Integer.parseInt(input.substring(0, 1));
        int f1 = 0;

        if (input.length() >= 2) {
            f1 = Integer.parseInt(input.substring(0, 2));
            if (f1 >= 10 && f1 <= 26) {
                out2 = getCode(input.substring(2));
            }
        }
        int k = 0;
        String[] ans = new String[out1.length + out2.length];
        for (int i = 0; i < out1.length; i++) {
            char c = table(f);
            ans[k] = c + out1[i];
            k++;
        }
        for (int i = 0; i < out2.length; i++) {
            char c = table(f1);
            ans[k] = c + out2[i];
            k++;
        }
        return ans;
    }

    public static char table(int input_char) {
        return (char) ('a' + input_char - 1);
    }

}
