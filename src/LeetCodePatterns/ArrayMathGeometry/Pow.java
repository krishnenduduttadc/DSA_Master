package LeetCodePatterns.ArrayMathGeometry;

public class Pow {
    public static void main(String[] args) {
        Pow solution = new Pow();
        // Test cases
        System.out.println(solution.myPow(2.0, 10));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double temp = myPow(x, n / 2);
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                if (n > 0) {

                    return temp * temp * x;
                } else {
                    return (temp * temp) / x;
                }
            }
        }
    }
}
