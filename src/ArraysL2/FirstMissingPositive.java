package ArraysL2;

public class FirstMissingPositive {
    //~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
    public static int firstMissingPositive(int[] arr) {
        // write your code here
        boolean one = false;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1)
                one = true;
            if (arr[i] < 1 || n < arr[i]) {
                arr[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int indx = Math.abs(arr[i]);
            arr[indx - 1] = -Math.abs(arr[indx - 1]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) return i + 1;
        }
        return n + 1;
    }

    //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        int[] arr = {9, 12, 4, 1, 2, -1, 8};
        int res = firstMissingPositive(arr);
        System.out.println(res);
    }
}
