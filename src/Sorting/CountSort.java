package Sorting;

public class CountSort {
    public static String countSort(String s) {
        char[] arr = s.toCharArray();
        char maxch = 'a';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxch) {
                maxch = arr[i];
            }
        }
        int max = maxch - 'a';
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] - 'a';
            count[val]++;
        }
        int k = 0;
        for (int i = 0; i <= max; i++) {
            int c = count[i];
            for (int j = 0; j < c; j++) {
                arr[k] = (char) (i + 'a');
                k++;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        // Hardcoded input string
        String input = "countingsortexample"; // Example input

        // Calling countSort to sort the string
        String sortedString = countSort(input);

        // Printing the sorted string
        System.out.println("Original String: " + input);
        System.out.println("Sorted String: " + sortedString);
    }
}
