package RecursionAndBacktrackingL3;

public class RestoreIpAddr {


    public static void main(String[] args) {
        String s = "25525511135";
        backtrack(s, 0, 0, "");
    }

    public static void backtrack(String s, int index, int parts, String current) {

        if (parts == 4 && index == s.length()) {
            System.out.println(current.substring(0, current.length() - 1));
            return;
        }

        if (parts > 4)
            return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String part = s.substring(index, index + len);

            if ((part.startsWith("0") && part.length() > 1) ||
                    Integer.parseInt(part) > 255)
                continue;

            backtrack(s, index + len, parts + 1, current + part + ".");
        }
    }

}
