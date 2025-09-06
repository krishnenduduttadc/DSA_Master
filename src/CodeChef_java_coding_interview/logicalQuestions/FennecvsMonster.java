package CodeChef_java_coding_interview.logicalQuestions;

import java.util.Arrays;
import java.util.stream.Stream;

public class FennecvsMonster {
    public static void main(String[] args) {
        int n = 10;
        int k = 9;
        String input = "10 12 7 9 3 2 3 8 4 6";
        int[] arr = Stream.of(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        ;
        long result = 0;
        for (int i = 0; i < n - k; i++) {
            result += arr[i];
        }
        System.out.println(result);
    }
}
