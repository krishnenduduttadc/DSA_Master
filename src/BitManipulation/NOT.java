package BitManipulation;

public class NOT {
    public static void main(String[] args) {
        int a = 5;      // Binary: 0101
        int result = ~a;  // Binary: 1010 (Decimal: -6 due to two's complement)
        System.out.println(result);
    }
}
