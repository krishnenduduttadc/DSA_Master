package CodingShuttle.Recursion;

public class AllSubsetsofAString {
    public static void main(String[] args) {
        String s = "abcc";
        printAllSubsets(s);
    }

    static void printAllSubsets(String s) {
        printAllSubsetsHelper(s, 0, "");
    }

    static void printAllSubsetsHelper(String s, int i, String cur) {
        if (i == s.length()) {
            System.out.println(cur);
            return;
        }
        printAllSubsetsHelper(s, i + 1, cur + s.charAt(i));
        printAllSubsetsHelper(s, i + 1, cur);
    }
}
