package ArraysL2;

public class MaxChunksToMakeArraySorted {
    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted(int[] arr) {
        // write your code here
        int max = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);

            if (i == max) {
                count++;
            }
        }

        return count;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};
        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }
}
