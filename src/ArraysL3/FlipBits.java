package ArraysL3;

public class FlipBits {
    public static int maxOnes(int a[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = -1;
                count++;
            }
        }

        int csum = 0;
        int osum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (csum >= 0) {
                csum += a[i];
            } else {
                csum = a[i];
            }

            osum = Math.max(csum, osum);
        }

        if (osum > 0) {
            return osum + count;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 0, 1, 1, 0, 1};
        int result1 = maxOnes(arr1, arr1.length);
        System.out.println("Max ones after modification: " + result1); // Expected output: 6
    }
    }
