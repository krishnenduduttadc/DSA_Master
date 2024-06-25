package BitManipulationL2;

public class ToggleithBit {
    public static void main(String[] args) {
        int n = 7;
        int k = 2;

        int ans = n^(1<<k);
        System.out.println(ans);
    }

}
