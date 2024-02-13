package java_coding_interview.logicalQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class SticksFindingMaximumRectangleArea {
    public static void main(String[] args) {
        int n = 5;
        int a[] = {1, 2, 3, 1, 2};
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        int chek_two_pairs = 2;
        int position = n - 1;

        while (chek_two_pairs > 0 && position > 0) {
            if (a[position] == a[position - 1]) {
                list.add(a[position]);
                position -= 2;
                chek_two_pairs--;
            } else {
                position--;
            }
        }


        if(chek_two_pairs>0){
            System.out.println(-1);
        }else{
            System.out.println(list.get(0)*list.get(1));
        }
    }
}
