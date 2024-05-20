package ArraysStrings;

public class StringAllUnique {
    public static void main(String[] args) {
        String str = "abcdd";
        System.out.println(f(str));
    }

    static boolean f(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            //System.out.println(val);
            if (set[val] == true) {
                return false;
            }
            set[val] = true;
        }
        return true;
    }

}
