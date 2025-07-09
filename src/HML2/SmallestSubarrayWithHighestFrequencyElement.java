package HML2;

import java.util.HashMap;

public class SmallestSubarrayWithHighestFrequencyElement {
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 4, 2, 3, 4, 2, 5, 6, 5, 5, 7};
        solution(arr);
    }

    static void solution(int[] arr) {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        HashMap<Integer, Integer> smap = new HashMap<>();
        int si = 0;
        int ei = 0;
        int len = ei - si + 1;
        int hfreq = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            fmap.put(val, fmap.getOrDefault(val, 0) + 1);
            if (!smap.containsKey(val)) {
                smap.put(val, i); // store first occurrence
            }

            if (fmap.get(val) > hfreq) {
                hfreq = fmap.get(val);
                si = smap.get(val);
                ei = i;
                len = ei - si + 1;
            } else if (fmap.get(val) == hfreq) {
                int clen = i - smap.get(val) + 1;
                if (clen < len) {
                    si = smap.get(val);
                    ei = i;
                    len = ei - si + 1;
                }
            }
        }

        System.out.println("Highest frequency element: " + arr[si]);
        System.out.println("Start index: " + si);
        System.out.println("End index: " + ei);
        System.out.print("Subarray: ");
        for (int i = si; i <= ei; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
