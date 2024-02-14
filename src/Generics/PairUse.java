/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;

/**
 *
 * @author krish
 */
public class PairUse {
    public static void main(String[] args) {
        Pair<String,Integer> p=new Pair<>("bapi",65);
        //p.setFirst(10);
        System.out.println(p.getFirst()+" "+p.getSecond());
    }
}
