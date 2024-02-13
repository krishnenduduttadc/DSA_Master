package java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class ChefAndKingship {
    public static void main(String[] args) {
        int n=6;
        int[] arr={15,10,7,13,2,4};
        Arrays.sort(arr);
        int min=arr[0];
        int sum=0;
        for (int i = 1; i < n; i++) {
            sum+=min*arr[i];
        }
        System.out.println(sum);
    }
}
