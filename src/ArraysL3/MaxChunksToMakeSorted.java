package ArraysL3;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int maxTillNow = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            maxTillNow = Math.max(maxTillNow, arr[i]);
            if (i == maxTillNow) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted solution = new MaxChunksToMakeSorted();
        int[] arr1 = {4, 3, 2, 1, 0};
        int result1 = solution.maxChunksToSorted(arr1);
        System.out.println("Max chunks to sort: " + result1); // Expected output: 1
    }
}
