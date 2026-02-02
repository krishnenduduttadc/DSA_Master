package CodingShuttle.Recursion;

public class PowerModulo {
    public static void main(String[] args) {

        double a = 7;
        int b = 7;
        int m = 30;

        System.out.println(fastPower(a, b, m));
    }

    static double fastPower(double a, int b, int m) {
        if (b == 0) return 1;

        if (b < 0) return fastPower(1 / a, Math.abs(b), m);

        if (b % 2 == 0) {
            return fastPower((a % m * a % m) % m, b / 2, m);
        } else {
            return (a % m * fastPower(a, b - 1, m) % m) % m;
        }
    }
}
