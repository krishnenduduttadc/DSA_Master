package CodeChef_java_coding_interview.logicalQuestions;

public class ChefandString {
    public static void main(String[] args) {
        String s = "CHEFCHEFFFF";
        int l = s.length();
        int c = 0;
        int h = 0;
        int e = 0;
        int f = 0;
        char[] a = s.toCharArray();

        for (int i = 0; i < l; i++) {
            if (a[i] == 'C') {
                c++;
            }
            if (a[i] == 'H' && c > h) {
                h++;
            }
            if (a[i] == 'E' && h > e) {
                e++;
            }
            if (a[i] == 'F' && e > f) {
                f++;
            }
        }
        System.out.println(f);
    }
}

