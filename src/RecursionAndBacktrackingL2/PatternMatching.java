package RecursionAndBacktrackingL2;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {
    static void match(String str, String pattern,
                      Map<Character, String> map) {

        // Base case
        if (pattern.length() == 0) {
            if (str.length() == 0) {
                System.out.println(map);
            }
            return;
        }

        char ch = pattern.charAt(0);
        String restPattern = pattern.substring(1);

        // If character already mapped
        if (map.containsKey(ch)) {

            String mapped = map.get(ch);

            // Check if string starts with mapped value
            if (str.startsWith(mapped)) {
                match(str.substring(mapped.length()), restPattern, map);
            }

        } else {
            // Try all possible substrings
            for (int i = 1; i <= str.length(); i++) {

                String left = str.substring(0, i);
                String right = str.substring(i);

                map.put(ch, left);
                match(right, restPattern, map);
                map.remove(ch);  // backtrack
            }
        }
    }

    public static void main(String[] args) {

        // Hardcoded input
        String str = "graphtreesgraph";
        String pattern = "pep";

        match(str, pattern, new HashMap<>());
    }
}

/*


graphtreesgraph
pep
 */
