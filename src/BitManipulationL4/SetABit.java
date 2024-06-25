package BitManipulationL4;

public class SetABit {
    public static void main(String[] args) {

        /*

        To set a specific bit at a given position (0-based index) to 1, you can use the bitwise OR operator (|) with a bitmask that has only that bit set.
Example: Setting the 3rd bit (index 2) to 1.
         */
        int num = 5; // Binary: 0101
        int bitmask = 1 << 2; // Binary: 0100
        int result = num | bitmask; // Binary: 0101 (Decimal: 5)
        System.out.println(result);

    }
}
