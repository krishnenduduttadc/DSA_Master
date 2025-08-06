package RecursionAndBacktrackingL0;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddr {
    public static void main(String[] args) {
        RestoreIpAddr obj = new RestoreIpAddr();
        String input = "25525511135";

        List<String> result = obj.restoreIpAddresses(input);

        System.out.println("Valid IP addresses from string \"" + input + "\":");
        for (String ip : result) {
            System.out.println(ip);
        }
    }

    public boolean isValid(String str) {
        if (
                str.isEmpty() ||
                        str.length() > 3 ||
                        (str.charAt(0) == '0' && str.length() > 1) ||
                        Integer.parseInt(str) > 255
        ) {
            return false;
        }
        return true;
    }

    public void dfs(List<String> list, String str, String path, int seg, int start) {
        if (seg == 4) {
            if (start == str.length()) {
                list.add(path.substring(0, path.length() - 1));
            }
            return;
        }
        for (int i = start; i < str.length() && i < start + 3; i++) {
            String curr = str.substring(start, i + 1);
            if (isValid(curr)) {
                dfs(list, str, path + curr + ".", seg + 1, i + 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return list;
        dfs(list, s, "", 0, 0);
        return list;
    }
}
