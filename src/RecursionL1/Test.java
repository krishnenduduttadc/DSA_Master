package RecursionL1;

public class Test {
    static void test(int a) {
        if (a < 0) {
            return;
        } else {
            System.out.println(a);
            test(a - 1);
        }
    }

    public static void main(String[] args) {
        int a = 5;
        test(a);
    }
}
