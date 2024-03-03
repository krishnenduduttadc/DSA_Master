package Recursion;

public class Sum {

    static void one2n(int n) {
        if (n == 0) {
            return;
        } else {
            one2n(n - 1);
            System.out.print(n + " ");
        }
    }

    static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return sum(n - 1) + n;
        }

    }

    static int repeat2(int n) {
        if (n == 1) {
            return 2;
        } else {
            return repeat2(n - 1) + 2;
        }
    }

    static int fact(int n) {
        if (n == 1) {
            return 1;
        } else {
            return fact(n - 1) * n;
        }
    }

    static int repeatmul3(int n) {
        if (n == 1) {
            return 3;
        } else {
            return repeatmul3(n - 1) * 3;
        }
    }

    static boolean palin(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) == str.charAt(end)) {
            return palin(str, start + 1, end - 1);
        } else {
            return false;
        }
    }

    static int sumofdig(int num) {
        if (num <= 9) {
            return num;
        } else {
            return (num % 10) + sumofdig(num / 10);
        }
    }

    static int countdig(int num) {
        if (num <= 9) {
            return 1;
        } else {
            return 1 + countdig(num / 10);
        }
    }

    static int sumarr(int a[], int n) {
        int i = n - 1;
        if (n == 0) {
            return 0;
        } else {
            return a[i] + sumarr(a, n - 1);
        }
    }

    static int maxinarr(int a[], int n) {
        int i = n - 1;
        int max = a[i];
        if (n == 1) {
            return max;
        } else {
            return Math.max(maxinarr(a, n - 1), max);
        }
    }

    static void subsets(String str, String curr, int index) {
        if (index == str.length()) {
            System.out.print(curr + " ");
            return;
        } else {
            subsets(str, curr, index + 1);
            subsets(str, curr + str.charAt(index), index + 1);
        }
    }

    static int subsetsum(int a[], int len, int sum) {
        if (len == 0) {
            return sum == 0 ? 1 : 0;
        }
        return subsetsum(a, len - 1, sum) + subsetsum(a, len - 1, sum - a[len - 1]);
    }

    public static void main(String a[]) {

        one2n(5);
        System.out.println(sum(15));
        System.out.println(repeat2(10));
        System.out.println(fact(5));
        System.out.println(repeatmul3(5));
        System.out.println(palin("abba", 0, "abba".length() - 1));
        System.out.println(sumofdig(243));
        System.out.println(countdig(2678));
        System.out.println(sumarr(new int[]{4, 5, 6, 3, 20}, 5));
        System.out.println(maxinarr(new int[]{48, 50, 68, 3, 20}, 5));
        subsets("ABC", "", 0);
        System.out.println(subsetsum(new int[]{10,20,15}, 3, 25));
    }
}
