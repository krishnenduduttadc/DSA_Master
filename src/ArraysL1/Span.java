package ArraysL1;

public class Span {
    public static void main(String[] args) throws Exception {
        // write your code here
        int[] arr = {15, 30, 40, 4, 11, 9};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(max - min);
    }
}


