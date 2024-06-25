package BitManipulationL3;

public class EvenOdd {
    public static void main(String[] args) {
        int x = 27;
        fun(x);

    }

    static void fun(int x) {
        if ((x & 1) == 0) {
            System.out.println("even");
        } else if ((x & 1) == 1) {
            System.out.println("odd");
        }
    }
}
