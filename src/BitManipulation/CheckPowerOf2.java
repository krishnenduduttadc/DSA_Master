package BitManipulation;

public class CheckPowerOf2 {
    public static void main(String[] args) {
        int num = 16; // Binary: 10000
        if ((num & (num - 1)) == 0) {
            System.out.println("The number is a power of 2.");
        }

    }
}
