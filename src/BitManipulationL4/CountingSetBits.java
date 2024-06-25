package BitManipulationL4;

public class CountingSetBits {
    public static void main(String[] args) {
        /*
        To count the number of set bits (1s) in an integer,
        you can use a loop that shifts the number right and checks the least significant bit.
         */
        int num = 11; // Binary: 1011
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        System.out.println("Number of set bits: " + count);

    }
}
