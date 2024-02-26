package java_coding_interview.logicalQuestions;

import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringinanArray {
    public static void main(String[] args) {
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;
        System.out.println(kthdis(arr,k));
    }

    static String kthdis(String[] arr, int k) {
        String result = "";
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int c = 1;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1 && c == k) {
                result = e.getKey();
                break;
            } else if (e.getValue() == 1) {
                c++;
            }
        }
        return result;
    }
}
