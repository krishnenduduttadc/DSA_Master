package StringsL1;

public class ToggleOpticaDocument {
    public static void main(String[] args) {
        String str = "pepCODinG";
        System.out.println(toggleCase(str));
    }

    static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                char uch = (char) ('A' + ch - 'a');
                sb.setCharAt(i, uch);
            } else if (ch >= 'A' && ch <= 'Z') {
                char lch = (char) ('a' + ch - 'A');
                sb.setCharAt(i, lch);
            }
        }
        return sb.toString();

    }


    static String toggleCase2(String str) {
        char[] chr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chr.length; i++) {
            if (chr[i] >= 65 && chr[i] <= 90) {
                chr[i] = (char) (chr[i] + 32);
            } else {
                chr[i] = (char) (chr[i] - 32);
            }
            sb.insert(i, chr[i]);
        }
        return sb.toString();

    }
}

/*
pepCODinG
 */
