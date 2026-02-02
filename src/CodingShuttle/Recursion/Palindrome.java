package CodingShuttle.Recursion;

public class Palindrome {
    public static void main(String[] args) {
        String s = "abcc";
        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    static boolean isPalindromeHelper(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) == s.charAt(r)) {
            return isPalindromeHelper(s, l + 1, r - 1);
        } else {
            return false;
        }
    }
}
