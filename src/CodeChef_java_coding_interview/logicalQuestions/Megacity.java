package CodeChef_java_coding_interview.logicalQuestions;


import java.util.Arrays;

class DistancePeoplePair implements Comparable<DistancePeoplePair> {
    int distance;
    int people;

    DistancePeoplePair(int dist, int ppl) {
        this.distance = dist;
        this.people = ppl;
    }

    public int compareTo(DistancePeoplePair o) {
        return distance - o.distance;
    }
}

public class Megacity {

    final static int MILLION = 1_000_000;

    static void solve() throws Exception {

        int n = 4, s = 999998;
        int[][] input = {{1, 1, 2}, {2, 2, 1}, {3, 3, 1}, {2, -2, 1}};

        if (s >= MILLION) {
            System.out.println(0);
            return;
        }

        DistancePeoplePair pairs[] = new DistancePeoplePair[n];

        for (int i = 0; i < n; i++) {
            int[] in = input[i];
            int x = in[0], y = in[1], k = in[2];
            int d2 = x * x + y * y;
            pairs[i] = new DistancePeoplePair(d2, k);
        }

        Arrays.sort(pairs);

        // simulating the expansion of the city
        for (int i = 0; i < n; i++) {
            s += pairs[i].people;

            if (s >= MILLION) {
                System.out.println(Math.sqrt(pairs[i].distance));
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solve();
    }
}
