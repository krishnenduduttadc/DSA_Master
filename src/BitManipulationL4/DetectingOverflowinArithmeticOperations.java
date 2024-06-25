package BitManipulationL4;

public class DetectingOverflowinArithmeticOperations {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE; // 2147483647
        int b = 1;
        int sum = a + b;
        if (((a ^ sum) & (b ^ sum)) < 0) {
            System.out.println("Overflow detected in addition.");
        }

    }
}
