package CodingShuttle.Hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyofAllElements {
    public static void main(String[] args) {
        int[] a = {1, 3, 3, 11, 2, 2};
        frequencyOfElements(a);
    }

    static void frequencyOfElements(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : a) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
