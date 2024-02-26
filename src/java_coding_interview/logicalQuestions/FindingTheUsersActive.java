package java_coding_interview.logicalQuestions;

import java.util.*;

public class FindingTheUsersActive {
    public static void main(String[] args) {
        int[][] logs = {
                {0, 5},
                {1, 2},
                {0, 2},
                {0, 5},
                {1, 3}
        };
        int k = 5;
        int[] res=findMins(logs,k);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] findMins(int[][] logs, int k) {
        int[] result = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int[] uam_log = logs[i];
            int userid = uam_log[0];
            int minute = uam_log[1];

            if (map.get(userid) == null) {
                Set<Integer> s = new HashSet<>();
                s.add(minute);
                map.put(userid, s);
            } else {
                Set<Integer> s = map.get(userid);
                s.add(minute);
                map.put(userid, s);
            }
        }

        Iterator<Map.Entry<Integer, Set<Integer>>> iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<Integer, Set<Integer>> e = iter.next();
            Set<Integer> set = e.getValue();
            result[set.size() - 1]++;
        }
        return result;
    }
}
