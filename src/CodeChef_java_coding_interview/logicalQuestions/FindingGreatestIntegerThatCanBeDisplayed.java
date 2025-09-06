package CodeChef_java_coding_interview.logicalQuestions;

public class FindingGreatestIntegerThatCanBeDisplayed {
    public static void main(String[] args) {
        int max_segments = 6;
        if (max_segments % 2 == 0) {
            while (max_segments > 0) {
                System.out.print(1);
                max_segments -= 2;
            }
        } else {
            System.out.println(7);
            for (int i = 0; i < max_segments - 3; i = i + 2) {
                System.out.print(1);
            }
        }
    }
}
