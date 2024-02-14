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

 interface A{
    public void method();
}
class One{
    public void method(){
        System.out.println("Class One method");
    }
}
class Two extends One implements A{
    public void method(){
        System.out.println("Class Two method");
    }
}
public class Solution extends Two{
    public static void main(String[] args){
        A a = new Two();
        a.method();     
    }
}
