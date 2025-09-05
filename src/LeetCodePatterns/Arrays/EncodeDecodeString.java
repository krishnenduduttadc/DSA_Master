package LeetCodePatterns.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

    public static void main(String[] args) {
        EncodeDecodeString codec = new EncodeDecodeString();

        List<String> strs1 = Arrays.asList("hello", "world");
        List<String> strs2 = Arrays.asList("a;b", "c/d", ";/");
        List<String> strs3 = Arrays.asList("", "empty", "string");

        // Test case 1
        String encoded1 = codec.encode(strs1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + codec.decode(encoded1));
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == ';') {
                    sb.append("/;");
                } else if (s.charAt(i) == '/') {
                    sb.append("//");
                } else {
                    sb.append(s.charAt(i));
                }
                i++;
            }
            sb.append(";");
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();

        StringBuilder currentString = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '/') {
                currentString.append(s.charAt(i + 1));
                i += 2;
            } else if (s.charAt(i) != ';') {
                currentString.append(s.charAt(i));
                i++;
            } else {
                decodedStrings.add(currentString.toString());
                currentString.setLength(0);
                i++;
            }
        }

        return decodedStrings;
    }
}
