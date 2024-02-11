package java_coding_interview.logicalQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int val, ind;

    Pair(int x, int y) {
        val = x;
        ind = y;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.val, o2.val);
    }
}

class PairComparatorReverse implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o2.val, o1.val);
    }
}

public class BusOfCharacters {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int n = 6;
        int[] width_arr = {10, 8, 9, 11, 13, 5};
        PriorityQueue<Pair> introvert_pq = new PriorityQueue<>(new PairComparator());
        for (int i = 1; i <= n; i++) {
            introvert_pq.add(new Pair(width_arr[i - 1], i));
        }

        String passengers = "010010011101";

        PriorityQueue<Pair> extrovert_pq = new PriorityQueue<>(new PairComparatorReverse());

        for (int i = 0; i < 2 * n; i++) {
            Pair temp = null;

            //introvert
            if (passengers.charAt(i) == '0') {
                temp = introvert_pq.poll();
                //adding introvert seat width to extrovert pq
                extrovert_pq.add(temp);
            } else {   //extrovert
                temp = extrovert_pq.poll();
            }

            System.out.print(temp.ind + " ");
        }
    }
}
