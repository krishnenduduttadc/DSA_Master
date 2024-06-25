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
public class StringofDigits {

    static void printCombinations(char[] input,
            int index,
            char[] output,
            int outLength) {
        if (input.length == index) {
            // print output string & return 
            System.out.println(String.valueOf(output));
            return;
        }

        // place current digit in input string 
        output[outLength] = input[index];

        // separate next digit with a space 
        output[outLength + 1] = ' ';

        printCombinations(input, index + 1, output,
                outLength + 2);

        // if next digit exists make a  
        // call without including space 
        if (input.length != index + 1) {
            printCombinations(input, index + 1, output,
                    outLength + 1);
        }

    }

    public static void main(String[] args) {
        char input[] = "1214".toCharArray();
        char[] output = new char[100];

        printCombinations(input, 0, output, 0);
    }
}
