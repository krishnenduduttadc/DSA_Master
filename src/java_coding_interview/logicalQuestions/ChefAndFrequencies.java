package java_coding_interview.logicalQuestions;

public class ChefAndFrequencies {
    public static void main(String[] args) {
        int n = 7;
        String s = "abbbccc";
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 97]++;
        }
        StringBuffer s1 = new StringBuffer();
        while (n-- > 0) {
            int max = 0;
            int ind = 0;
            for (int i = 0; i < 26; i++) {
                if (max < a[i]) {
                    max = a[i];
                    ind = i;
                }
            }
            a[ind]--;
            s1.append((char)(97+ind));
        }

        System.out.println(s1);
    }
}
