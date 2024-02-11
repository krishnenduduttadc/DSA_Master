package java_coding_interview.logicalQuestions;

public class RegularBracketSequence {
    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        String s = "((()())";
        char[] char_arr = s.toCharArray();
        int n = char_arr.length;
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (char_arr[i] == '(') {
                l++;
            } else if (l > 0) {
                l--;
                r++;
            }
        }
        System.out.println(r * 2);
    }
}
