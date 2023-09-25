package BitManipulation;

public class Swap {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
// Now, 'a' holds 7 and 'b' holds 5
        System.out.println(a);
        System.out.println(b);
    }
}
