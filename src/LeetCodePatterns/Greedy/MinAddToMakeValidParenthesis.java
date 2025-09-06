package LeetCodePatterns.Greedy;

public class MinAddToMakeValidParenthesis {

    public static void main(String[] args) {
        String s1 = "())";
        String s2 = "(((";
        String s3 = "())(()";

        MinAddToMakeValidParenthesis solution = new MinAddToMakeValidParenthesis();

        System.out.println("Min additions for \"" + s1 + "\": " + solution.minAddToMakeValid(s1));
        System.out.println("Min additions for \"" + s2 + "\": " + solution.minAddToMakeValid(s2));
        System.out.println("Min additions for \"" + s3 + "\": " + solution.minAddToMakeValid(s3));
    }

    public int minAddToMakeValid(String s) {
        int count = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                ans++;
                count++;
            }
        }

        if (count > 0) {
            ans += count;
        }

        return ans;

    }
}
