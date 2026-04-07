package RecursionAndBacktrackingL3;

public class MinTimeToFinishJobs {

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] jobs = {3, 2, 3};
        int k = 3;
        int[] workers = new int[k];
        backtrack(jobs, 0, workers);
        System.out.println(result);
    }

    public static void backtrack(int[] jobs, int index, int[] workers) {

        if (index == jobs.length) {
            int max = 0;
            for (int w : workers)
                max = Math.max(max, w);
            result = Math.min(result, max);
            return;
        }

        for (int i = 0; i < workers.length; i++) {

            if (i > 0 && workers[i] == workers[i - 1])
                continue;
            workers[i] += jobs[index];
            backtrack(jobs, index + 1, workers);
            workers[i] -= jobs[index];
            if (workers[i] == 0)
                break;
        }
    }
}
