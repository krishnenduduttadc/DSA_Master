package CodeChef_java_coding_interview.logicalQuestions;

import java.util.Arrays;

class Order implements Comparable<Order> {
    int delivery;
    int pickUP;

    @Override
    public int compareTo(Order o) {
        return this.delivery - o.delivery;
    }
}

public class DeliveryDillema {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int n = 4;

        Order orders[] = new Order[n];
        // int[] delivery = { 1, 2, 3, 4 };
        // int[] pickup = { 3, 3, 3, 3 }; // [9, 6, 3, 4]

        int[] delivery = {1, 2, 3, 4};
        int[] pickup = {3, 3, 3, 3}; // [3, 2, 3, 4]

        long answer = Long.MAX_VALUE;
        long total_picked = 0;

        long results[] = new long[n];

        for (int i = 0; i < n; i++) {
            orders[i] = new Order();
            orders[i].delivery = delivery[i];
        }

        for (int i = 0; i < n; i++) {
            orders[i].pickUP = pickup[i];
        }

        Arrays.sort(orders);

        for (int i = 0; i < n; i++) {
            total_picked += orders[i].pickUP;
        }

        answer = total_picked;

        for (int i = 0; i < n; i++) {
            total_picked -= orders[i].pickUP;
            results[i] = Math.max(orders[i].delivery, total_picked);
        }

        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, results[i]);
        }

        System.out.println(answer);

    }
}
