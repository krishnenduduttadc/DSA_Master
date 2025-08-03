package ArraysL2;

public class ConsecutiveNumbersSum {
    public static int consecutiveNumbersSum(int n) {
        // write your code here
        int c = 0;
        for (int k = 1; n > (k * (k - 1) / 2); k++) {
            int n1 = n - (k * (k - 1) / 2);
            if (n1 % k == 0) {
                c++;
            }
        }
        return c;
    }

    // ~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        int num = 5;
        int res = consecutiveNumbersSum(num);
        System.out.println(res);
    }
}
