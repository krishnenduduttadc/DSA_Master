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
public class CopyString {

    static void myCopy(char s1[], char s2[], int index) {
        s2[index] = s1[index];
        if (index == s1.length - 1) {
            return;
        }
        myCopy(s1, s2, index + 1);
    }

    public static void main(String[] args) {
        char s1[] = "GEEKSFORGEEKS".toCharArray();
        char s2[] = new char[s1.length];
        int index = 0;
        myCopy(s1, s2, index);
        System.out.println(String.valueOf(s2));
    }
}
