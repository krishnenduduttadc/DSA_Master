package java_coding_interview.logicalQuestions;

import java.util.HashSet;

public class AProblemonSticks {
    public static void main(String[] args) {
        int n=4;
        int[] input={1,2,3,5};
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(input[i]);
        }
        set.remove(0);
        System.out.println(set.size());
    }
}
