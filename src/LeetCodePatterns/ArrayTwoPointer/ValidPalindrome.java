package LeetCodePatterns.ArrayTwoPointer;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        // Expected: true
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left <= right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}
