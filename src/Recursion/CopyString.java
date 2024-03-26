/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author krish
 */
public class CopyString {

    static void myCopy(char s1[], char s2[], int i) {
        if(i==s2.length){
            return;
        }
        s2[i]=s1[i];
        myCopy(s1,s2,i+1);
    }

    public static void main(String[] args) {
        char s1[] = "GEEKSFORGEEKS".toCharArray();
        char s2[] = new char[s1.length];
        int index = 0;
        myCopy(s1, s2, index);
        System.out.println(String.valueOf(s2));
    }
}
