package BitManipulationResearch;

public class AllElementsOfSet {
    public static void main(String[] args) {
        int x = 282; // 100011010
        //x=7; //111
        set(x);
    }

    static void set(int x) {
        for (int i = 0; i < 32; i++) {
            if ((x & (1 << i)) != 0) {
                System.out.println(i);
            }
        }
    }
}
