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
public class StringofLenK {

    private static void printAllKLength(char[] set, int k) {
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
    }

    static void printAllKLengthRec(char[] set,
            String prefix,
            int n, int k) {

        if (k == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < n; i++) {
            String newprefix = prefix + set[i];
            printAllKLengthRec(set, newprefix, n, k - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("First Test");
        char[] set1 = {'a', 'b','c','d'};
        int k = 3;
        printAllKLength(set1, k);
    }

}
