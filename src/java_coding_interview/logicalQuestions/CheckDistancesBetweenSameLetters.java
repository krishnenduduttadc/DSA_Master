package java_coding_interview.logicalQuestions;

public class CheckDistancesBetweenSameLetters {
    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(check(s, distance));
    }

    static boolean check(String s, int[] distance) {
        int N = s.length();
        for (int i = 0; i < N; i++) {
            char current_char = s.charAt(i);
            int f_idx = s.indexOf(current_char);
            int l_idx = s.lastIndexOf(current_char);
            int dist = l_idx - f_idx - 1;
            if (distance[current_char - 'a'] == dist) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
