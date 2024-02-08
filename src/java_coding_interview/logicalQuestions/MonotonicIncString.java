package java_coding_interview.logicalQuestions;

public class MonotonicIncString {
    public static void main(String[] args) {
        String str = "001100";
        System.out.println(minFlips(str));
    }

    public static int minFlips(String s) {
        int min_flips = 0;
        int one_cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                one_cnt++;
            } else {
                min_flips = Math.min(min_flips + 1, one_cnt);
            }
        }
        return min_flips;
    }
}
