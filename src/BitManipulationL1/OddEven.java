/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BitManipulationL1;

/**
 *
 * @author krish
 */
public class OddEven {
    public static void main(String[] args) {
        int a=7;
        System.out.println(""+(a&1));
        if((a&1)==1){
            System.out.println("odd");
        }else{
            System.out.println("even");
        }
    }
}
