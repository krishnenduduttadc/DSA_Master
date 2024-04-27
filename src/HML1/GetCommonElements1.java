package HML1;

import java.util.HashMap;

public class GetCommonElements1 {
    public static void main(String[] args) throws Exception {
        // write your code here

        int[] a1 = {5, 5, 9, 8, 5, 5, 8, 0, 3};
        int[] a2 = {9, 7, 1, 0, 3, 6, 5, 9, 1, 1, 8, 0, 2, 4, 2, 9, 1, 5};

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : a1) {
            if (hm.containsKey(val)) {
                int of = hm.get(val);
                int nf = of + 1;
                hm.put(val, nf);
            } else {
                hm.put(val, 1);
            }
        }

        for (int val : a2) {
            if (hm.containsKey(val)) {
                System.out.println(val);
                hm.remove(val);
            }
        }

    }

}

/*
9
5
5
9
8
5
5
8
0
3
18
9
7
1
0
3
6
5
9
1
1
8
0
2
4
2
9
1
5
 */
