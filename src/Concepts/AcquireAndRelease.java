package Concepts;

import java.util.HashMap;

public class AcquireAndRelease {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 4, 3, 2, 9, 1, 6};
        int k = 4;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;

        //acquire
        for (i = 0; i < k - 1; ) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            i++;
        }

        for (i = k - 1, j = 0; i < arr.length; i++, j++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            //print
            for (int l = j; l <= i; l++) {
                System.out.print(arr[l]);
                if (l < i) {
                    System.out.print(",");
                } else {
                    System.out.println();
                }
            }


            //relase
            if (map.get(arr[j]) == 1) {
                map.remove(arr[j]);
            } else {
                map.put(arr[j], map.getOrDefault(arr[j], 0) - 1);
            }

        }
        //System.out.println(map);

    }
}

