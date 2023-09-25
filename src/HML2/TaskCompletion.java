package HML2;

import java.util.ArrayList;
import java.util.HashSet;

public class TaskCompletion {
    public static void main(String[] args) {
        int n = 156;
        int m = 256794;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        complete(n,m,arr);
    }

    static void complete(int n, int m, int[] arr) {
        HashSet<Integer> comp = new HashSet<>();
        for (int val : arr) {
            comp.add(val);
        }
        boolean flag = true;
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (comp.contains(i) == false) {
                if (flag) {
                    one.add(i);
                } else {
                    two.add(i);
                }
                flag = !flag;
            }
        }

        for (int val : one) {
            System.out.println(val + " ");
        }
        System.out.println();
        for (int val : two) {
            System.out.println(val + " ");
        }
        System.out.println();
    }
}
