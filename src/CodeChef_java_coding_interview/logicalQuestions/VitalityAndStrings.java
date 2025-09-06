package CodeChef_java_coding_interview.logicalQuestions;

public class VitalityAndStrings {
    public static void main(String[] args) {
        String s = "aaa";
        String t = "ddd";
        char[] char_arr = t.toCharArray();
        for (int i = char_arr.length - 1; i >= 0; --i) {
            if (char_arr[i] == 'a') {
                char_arr[i] = 'z';
            } else {
                char_arr[i]--;
                break;
            }
        }

        String res = new String(char_arr);
        System.out.println(res.equals(s) ? "No such strings" : res);
    }
}
