package CodeChef_java_coding_interview.logicalQuestions;

public class ReplaceElementswithGreatestElementonRightSide {
    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] res = replaceElements(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    static int[] replaceElements(int[] arr) {
        int gr = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = gr;

            if (temp > gr) {
                gr = temp;
            }
        }
        return arr;
    }
}
