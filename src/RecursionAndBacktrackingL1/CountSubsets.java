package RecursionAndBacktrackingL1;

public class CountSubsets {


        public static int countSubsets(int[] arr, int n, int i, int X) {

            if (i == n) {
                if (X == 0) {
                    return 1;
                }
                return 0;
            }

            int inclu = countSubsets(arr, n, i + 1, X - arr[i]);
            int exclu = countSubsets(arr, n, i + 1, X);
            return inclu + exclu;
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int X = 10;

            System.out.println(countSubsets(arr, arr.length, 0, X));
        }

}
