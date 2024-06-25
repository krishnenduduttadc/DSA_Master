package BitManipulationL4;

public class TogglingABit {
    public static void main(String[] args) {
        /*
        To toggle a specific bit, you can use the bitwise XOR operator (^) with a bitmask that has only that bit set.
Example: Toggling the 1st bit (index 0).
         */
        int num = 9; // Binary: 1001
        int bitmask = 1 << 0; // Binary: 0001
        int result = num ^ bitmask; // Binary: 1000 (Decimal: 8)
        System.out.println(result);
    }
}
