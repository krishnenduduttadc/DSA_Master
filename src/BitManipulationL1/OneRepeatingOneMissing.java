package BitManipulationL1;

public class OneRepeatingOneMissing {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 4, 5, 6, 7};
        solution(arr);
    }

    public static void solution(int[] arr) {
        //write your code here
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= arr.length; i++) {
            xor ^= i;
        }

        int rsb = xor & -xor;

        int x = 0;
        int y = 0;

        for (int val : arr) {
            if ((val & rsb) == 0) {
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            if ((i & rsb) == 0) {
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }

        for (int val : arr) {
            if (val == x) {
                System.out.println("Missing Number -> " + y);
                System.out.println("Repeating Number -> " + x);
                break;
            } else if (val == y) {
                System.out.println("Missing Number -> " + x);
                System.out.println("Repeating Number -> " + y);
                break;
            }
        }

    }
}
