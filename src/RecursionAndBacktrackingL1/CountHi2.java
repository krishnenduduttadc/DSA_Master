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
public class CountHi2 {

    public static void main(String[] args) {
        int p = countHi2("xhixhi");
        System.out.println("" + p);
    }

    public static int countHi2(String str) {

        if(str.length()<2){
            return 0;
        }
        
        
        if(str.substring(0,2).equals("hi")){
            return 1+countHi2(str.substring(2));
        }
        else if(str.length()> 2 && str.substring(0,3).equals("xhi")){
            return countHi2(str.substring(3));
        }else{
            return countHi2(str.substring(1));
        }
    }

}
