package HML2;


import java.util.HashMap;

public class Equal012 {
    public static int[] funcc(String str, char num) {
        int n = str.length();
        int[] ans = new int[n];
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == num) {
                c++;
            }
            ans[i] = c;
        }
        return ans;
    }

    public static void main(String[] args) {
        Equal012 solution = new Equal012();

        // Test cases
        String[] testCases = {
                "102100211",
                "102011",
                "10212",
                "102012",
                "102012201210021"
        };

        for (String testCase : testCases) {
            long result = solution.getSubstringWithEqual012(testCase);
            System.out.println("String: " + testCase + " => Substrings with equal number of '0's, '1's, and '2's: " + result);
        }
    }

    long getSubstringWithEqual012(String str) {
        HashMap<String, Long> map = new HashMap<>();
        int n = str.length();
        int[] pc0 = funcc(str, '0');
        int[] pc1 = funcc(str, '1');
        int[] pc2 = funcc(str, '2');
        long ans = 0;
        map.put("0@0", 1L);

        for (int ep = 0; ep < n; ep++) {
            int diff1 = pc0[ep] - pc1[ep];
            int diff2 = pc0[ep] - pc2[ep];
            String diff = diff1 + "@" + diff2;
            ans = ans + map.getOrDefault(diff, 0L);
            map.put(diff, map.getOrDefault(diff, 0L) + 1);
        }
        return ans;
    }
}
