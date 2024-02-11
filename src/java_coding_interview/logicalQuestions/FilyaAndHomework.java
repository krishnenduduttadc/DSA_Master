package java_coding_interview.logicalQuestions;

import java.util.TreeSet;

public class FilyaAndHomework {
    public static void main(String[] args) {
        int n = 5;
        int[] input = {1, 3, 3, 2, 1};
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(input[i]);
        }

        if (set.size() < 3) {
            System.out.println("YES");
        } else if (set.size() == 3) {
            int first = set.first();
            set.remove(first);
            int second = set.first();
            set.remove(second);
            int third = set.first();

            if(second==third -second+first){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }else{
            System.out.println("NO");
        }
    }
}
