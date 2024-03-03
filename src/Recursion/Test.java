/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author krishnendu
 */
public class Test {

    public static void main(String a[]) {
        String inp = "aaabaaa";
        System.out.println("" + isPal(inp, 0, inp.length() - 1));
        
        System.out.println(sumOfDig(567));
        
        printSubsequences("ABC","",0);
    }

    private static void prn(int i) {
        if (i == 0) {
            return;
        }
        prn(i - 1);
        System.out.println(i);
    }

    private static void prni(int i) {
        if (i == 0) {
            return;
        }
        System.out.print(i + " ");
        prn(i - 1);

    }

    static boolean isPal(String str, int s, int e) {
        if (s == e) {
            return true;
        }
        if (str.charAt(s) != str.charAt(e)) {
            return false;
        }
        return isPal(str, (s + 1), (e - 1));
    }

    static int sumOfDig(int n) {
        if (n < 10) {
            return n;
        }
        return sumOfDig(n / 10) + n % 10;
    }
    
    static void printSubsequences(String str,String curr,int index ){
        if(index==str.length()){
            System.out.print(curr + " "); return;
        }
        
        printSubsequences(str,curr,index+1);
        printSubsequences(str, curr+str.charAt(index), index+1);
    }
}
