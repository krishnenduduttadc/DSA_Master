package BitManipulation;

public class ReverseBits {
    public static void main(String[] args) {
        int num = 25; // Binary: 00011001
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed = (reversed << 1) | ((num >> i) & 1);
        }
// 'reversed' now contains the integer with reversed bits (147)
        System.out.println(reversed);
    }
}
