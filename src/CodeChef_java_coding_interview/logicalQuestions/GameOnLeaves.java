package CodeChef_java_coding_interview.logicalQuestions;

public class GameOnLeaves {
    public static void main(String[] args) {
        int n = 6;
        int x = 3;
        int[][] input = {{2, 1}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
        StringBuilder sb = new StringBuilder();
        int[] deg = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            int[] in = input[i];
            int u = in[0];
            int v = in[1];
            deg[u]++;
            deg[v]++;
        }

        if (deg[x] <= 1) {
            sb.append("Ayush\n");
        } else {
            if (n % 2 == 0) {
                sb.append("Ayush\n");
            } else {
                sb.append("Ashish\n");
            }
        }
        System.out.println(sb.toString());
    }
}
