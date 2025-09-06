package LeetCodePatterns.Graph;

public class FindTownJudge {
    public static void main(String[] args) {
        int n = 4;
        int[][] trust = {
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        };

        FindTownJudge solution = new FindTownJudge();
        int judge = solution.findJudge(n, trust);

        System.out.println("The town judge is: " + judge);
    }

    public int findJudge(int n, int[][] trust) {
        int[] outdegree = new int[n + 1];
        int[] indegree = new int[n + 1];

        for (int[] rel : trust) {
            int from = rel[0];
            int to = rel[1];

            indegree[to]++;
            outdegree[from]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
