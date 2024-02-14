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
public class Countabcaba {

    public static void main(String[] args) {
        int p = countAbc("abcabcababbb");
        System.out.println("" + p);
    }

    public static int countAbc(String str) {
        if (str.length() <3) {
            return 0;
        }
        
        int small=countAbc(str.substring(2));
        if(str.substring(0, 3).equals("abc") || str.substring(0,3).equals("aba")){
            return 1+small;
        }else{
            return countAbc(str.substring(1));
        }
    }

}
