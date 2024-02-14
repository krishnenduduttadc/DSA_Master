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
public class CountPairs {

    public static void main(String[] args) {
        int p = countPairs("axbx");
        System.out.println("" + p);
    }

    public static int countPairs(String str) {
      
        if(str.length()<=2){
            return 0;
        }
        
        int small=countPairs(str.substring(1));
        if( str.charAt(0)==str.charAt(2)){
            return 1+small;
        }else{
            return small;
        }
    }
}
