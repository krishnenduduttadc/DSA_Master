package CodingShuttle.Hashing;

import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
        int[] a = {1, 3, 3, 11, 2, 2};
        System.out.println(countDistinctElements(a));
    }

    static int countDistinctElements(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int e : a) {
            set.add(e);
        }
        return set.size();
    }
}
