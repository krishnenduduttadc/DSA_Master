package BitManipulationTheory;

public class FindingthePowerof2GreaterorEqualtoaGivenNumber {
    public static void main(String[] args) {
        int num = 15; // Find the smallest power of 2 >= 15
        int powerOf2 = 1;
        while (powerOf2 < num) {
            powerOf2 <<= 1;
        }
        System.out.println("Smallest power of 2 >= " + num + ": " + powerOf2); // Output: 16

    }
}
