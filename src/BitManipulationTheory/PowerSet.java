package BitManipulationTheory;

public class PowerSet {
    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c'};
        int n = set.length;
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println("}");
        }
// This generates all subsets of {a, b, c}

    }
}
