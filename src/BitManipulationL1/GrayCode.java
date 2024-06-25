package BitManipulationL1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrayCode {
    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            ans.add(0);
            return ans;
        }
        backtrack(ans, n);
        return ans;
    }

    static int temp;

    private static void backtrack(List<Integer> ans, int n) {
        if (n==0) {
            ans.add(temp);
            return;
        }

        backtrack(ans, n-1);

        temp = temp ^ (1 << (n - 1));
        backtrack(ans, n - 1);
    }

    public static void main(String[] args) {

        List<Integer> ans=grayCode(3);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
