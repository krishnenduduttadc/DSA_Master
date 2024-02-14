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
public class Print {

    static <T extends PrintInterface> void printArray(T arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
//        Integer a[] = new Integer[10];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = i + 1;
//        }
//        printArray(a);
//
//        String p[] = new String[10];
//        for (int i = 0; i < p.length; i++) {
//            p[i] = "aaa";
//        }
//        printArray(p);

        Student s1[] = new Student[10];
        for (int i = 0; i < s1.length; i++) {
            s1[i] = new Student(i+10);
        }
        printArray(s1);

    }
}
