package CodingShuttle.Recursion;

public class SumofNNatural {
    public static void main(String[] args) {
        System.out.println(sumOfN(5));
    }

    static int sumOfN(int n) {
        if (n == 1) return 1;
        return sumOfN(n - 1) + n;
    }

    static void fun(int n) {
        if (n > 0) {
            System.out.println(n);
            fun(n - 1);
        }
    }

    static void foo(int n) {
        if (n > 0) {
            foo(n - 1);
            System.out.println(n);
        }
    }

    static void bar(int n) {
        if (n > 0) {
            System.out.println(n);
            bar(n - 1);
            bar(n - 1);
        }
    }
}
