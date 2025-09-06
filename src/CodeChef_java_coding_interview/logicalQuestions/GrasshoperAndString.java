package CodeChef_java_coding_interview.logicalQuestions;

public class GrasshoperAndString {
    static String PLACE_HOLDER = ".";

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        String str = "ABABBBACFEYUKOTT";
        str = str.replaceAll("A", PLACE_HOLDER);
        str = str.replaceAll("E", PLACE_HOLDER);
        str = str.replaceAll("I", PLACE_HOLDER);
        str = str.replaceAll("O", PLACE_HOLDER);
        str = str.replaceAll("U", PLACE_HOLDER);
        str = str.replaceAll("Y", PLACE_HOLDER);

        int max = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                count = 1;
            } else {
                count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
