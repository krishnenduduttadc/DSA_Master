package CodeChef_java_coding_interview.logicalQuestions;

public class MaximumControl {
    public static void main(String[] args) {
        int n = 4;
        int[][] input = {{4, 1}, {4, 2}, {1, 3}, {1, 5}};
        int[] tunnels_arr = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            int[] in = input[i];
            tunnels_arr[in[0]]++;
            tunnels_arr[in[1]]++;
        }
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (tunnels_arr[i] == 1) {
                c++;
            }
        }
        System.out.println(c);
    }
}
