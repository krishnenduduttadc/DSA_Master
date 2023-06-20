package DP1;

public class MaximumSumNonAdjacentElements {
    public static void main(String[] args) {
        int n = 6;

        int[] arr = {5,10,10,100,5,6};


        int inc = arr[0];
        int exc = 0;

        for(int i = 1; i < arr.length; i++){
            int ninc = exc + arr[i];
            int nexc = Math.max(inc, exc);

            inc = ninc;
            exc = nexc;
        }

        int ans = Math.max(inc, exc);
        System.out.println(ans);
    }
}
