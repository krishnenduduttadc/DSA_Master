/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionL1;

/**
 *
 * @author krish
 */
public class IsPalindrome {
    static boolean ispalindrome(String str,int start,int end){
        if(start>=end)return true;
        if(str.charAt(start)==str.charAt(end)){
            return ispalindrome(str,start+1,end-1);
        }else{
            return false;
        }
    }
    public static void main(String a[]) {
        String input="haaaah";
        System.out.println(ispalindrome(input,0,input.length()-1));
    }
}
