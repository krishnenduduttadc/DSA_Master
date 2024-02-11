package java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class Fox_Box_Accumulation {
    public static void solve() {
        int n = 6;
        int a[] = { 0, 1, 1, 2, 2, 4 };

        Arrays.sort(a);

        int number_of_piles = 0;

        int number_of_boxes_put_in_pile = 0;

        // when we are putting the box into a pile, we will mark it as "visited", so
        // that we don't want to re-visit it.
        // (as a box can only be put into one pile)
        boolean[] visited_box = new boolean[n];

        while (number_of_boxes_put_in_pile < n) {

            number_of_piles += 1;

            int sum = 0;

            for (int j = 0; j < n; j++) {

                if (!visited_box[j] && sum <= a[j]) {

                    sum += 1;

                    visited_box[j] = true;

                    // number of boxes put in pile
                    number_of_boxes_put_in_pile++;
                }

            }
        }

        System.out.println(number_of_piles);
    }

    public static void main(String[] args) {
        solve();
    }
}
