package RecursionL2;

public class StringPermutation {

    public static void main(String[] args) {
        char[] a = "123".toCharArray();
        f(a, 0);
    }

    static void f(char[] a, int i) {
        if (i == a.length) {
            System.out.println(new String(a));
            return;
        }
        for (int j = i; j < a.length; j++) {
            char t = a[j];
            a[j] = a[i];
            a[i] = t;

            f(a, i + 1);

            t = a[i];
            a[i] = a[j];
            a[j] = t;

        }

    }
}
