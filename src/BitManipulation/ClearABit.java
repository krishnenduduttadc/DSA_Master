package BitManipulation;

public class ClearABit {
    public static void main(String[] args) {
        /*
        To clear a specific bit at a given position to 0, you can use the bitwise AND operator (&) with a bitmask that has only that bit cleared (complement).
Example: Clearing the 2nd bit (index 1).
         */
        int num = 6; // Binary: 0110
        int bitmask = ~(1 << 1); // Binary: 1101
        int result = num & bitmask; // Binary: 0100 (Decimal: 4)

    }
}
