package BitManipulationTheory;

public class BitwiseMultiplicationbyaConstant {
    public static void main(String[] args) {
        int num = 5;
        int constant = 3;
        int result = (num << 1) + num; // Multiply by 3 using bit manipulation
        System.out.println("Result: " + result); // Output: 15

    }
}
