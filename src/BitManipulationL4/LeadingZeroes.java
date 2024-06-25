package BitManipulationL4;

public class LeadingZeroes {
    public static void main(String[] args) {
        int num = 7; // Binary: 00000111
        int leadingZeros = 0;
        while ((num & (1 << 31)) == 0) {
            leadingZeros++;
            num <<= 1;
        }
        System.out.println("Leading zeros: " + leadingZeros); // Output: 28

    }
}
