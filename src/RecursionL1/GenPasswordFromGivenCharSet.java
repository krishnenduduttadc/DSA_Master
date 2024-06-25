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
public class GenPasswordFromGivenCharSet {
    
    static void generate(char[] arr, int i, String s, int len) 
    { 
        if(i==0){
            System.out.println(s); 
            return;
        }
        for(int j=0;j<len;j++){
            String app=s+arr[j];
            generate(arr, i-1, app, len);
        }
        return;       
    }
    static void crack(char[] arr, int len) 
    { 
        for (int i = 1; i <= len; i++) 
        { 
            generate(arr, i, "", len); 
        } 
    } 
    public static void main(String[] args) 
    { 
        char arr[] = {'a', 'b', 'c'}; 
        int len = arr.length; 
        crack(arr, len); 
    } 
}
