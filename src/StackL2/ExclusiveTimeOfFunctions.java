package StackL2;

import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public static void main(String[] args) {
        // Hardcoded input
        int n = 2; // number of functions
        String[] logs = {
                "0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6"
        };

        int[] timeF = new int[n];
        Stack<Pair> st = new Stack<>();

        for (String logEntry : logs) {
            String[] log = logEntry.split(":");

            if (log[1].equals("start")) {
                Pair p = new Pair();
                p.id = Integer.parseInt(log[0]);
                p.st = Integer.parseInt(log[2]);
                p.ct = 0;
                st.push(p);
            } else {
                Pair p = st.pop();
                int interval = Integer.parseInt(log[2]) - p.st + 1;
                int time = interval - p.ct;
                timeF[p.id] += time;

                if (!st.isEmpty()) {
                    st.peek().ct += interval;
                }
            }
        }

        for (int e : timeF) {
            System.out.println(e);
        }
    }

    static class Pair {
        int id;
        int st;
        int ct;
    }
}
