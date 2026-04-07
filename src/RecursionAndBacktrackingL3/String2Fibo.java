package RecursionAndBacktrackingL3;

import java.util.ArrayList;
import java.util.List;

public class String2Fibo {


    public static void main(String[] args) {
        String s = "123456579";
        backtrack(s, 0, new ArrayList<>());
    }

    public static boolean backtrack(String s, int index, List<Integer> list) {

        if (index == s.length()) {
            if (list.size() >= 3) {
                System.out.println(list);
                return true;
            }
            return false;
        }

        for (int i = index; i < s.length(); i++) {

            if (i > index && s.charAt(index) == '0')
                break;

            long num = Long.parseLong(s.substring(index, i + 1));
            if (num > Integer.MAX_VALUE)
                break;

            int size = list.size();

            if (size >= 2) {
                long sum = (long) list.get(size - 1) + list.get(size - 2);
                if (num < sum) continue;
                if (num > sum) break;
            }

            list.add((int) num);

            if (backtrack(s, i + 1, list))
                return true;

            list.remove(list.size() - 1);
        }
        return false;
    }

}
