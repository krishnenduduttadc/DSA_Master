package BitManipulationL4;

public class EvenOdd {
    public static void main(String[] args) {
        int num = 7;
        if ((num & 1) == 0) {
            System.out.println("The number is even.");
        } else {
            System.out.println("The number is odd.");
        }

    }
}
