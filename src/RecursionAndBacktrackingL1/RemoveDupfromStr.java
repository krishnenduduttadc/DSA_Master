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
public class RemoveDupfromStr {
    
    static String dup(String str){
        if(str.length()==0){
            return "";
        }
        char f=str.charAt(0);
        String ans=dup(str.substring(1));
        if(f==ans.charAt(0)){
            return ans;
        }else{
            return f+ans;
        }
        
    }
    public static void main(String[] args) {
        String s="aaaabbbeeecdddd";
        //System.out.println(s.charAt(1));
        System.out.println(""+dup(s));
    }
}
