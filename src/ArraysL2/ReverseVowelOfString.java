package ArraysL2;

public class ReverseVowelOfString {
    static boolean isVowel(char[] arr, int idx) {
        char ch = arr[idx];
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
        ) {
            return true;
        }
        return false;
    }

    static void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static String reverseVowel(String s) {
        char arr[] = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (left < right && isVowel(arr, left) == false) {
                left++;
            }

            while (left < right && isVowel(arr, right) == false) {
                right++;
            }
            swap(arr, left, right);
            left++;
            right--;
        }
        String str = "";
        for (char ch : arr) {
            str += ch;
        }
        return str;
    }

    public static void main(String[] args) {
        String s = reverseVowel("hello");
        System.out.println(s);
    }
}
