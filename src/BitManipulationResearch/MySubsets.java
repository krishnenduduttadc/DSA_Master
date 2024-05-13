package BitManipulationResearch;

public class MySubsets {
    public static void main(String[] args) {
        int n = 4;
        for (int b = 0; b < (1 << n); b++) {
            System.out.println(b);
        }
    }
}
