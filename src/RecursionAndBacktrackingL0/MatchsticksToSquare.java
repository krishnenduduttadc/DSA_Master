package RecursionAndBacktrackingL0;

public class MatchsticksToSquare {

    public static void main(String[] args) {
        MatchsticksToSquare obj = new MatchsticksToSquare();
        int[] matchsticks = {1, 1, 2, 2, 2};
        boolean result = obj.makesquare(matchsticks);
        System.out.println("Can the matchsticks form a square?");
        System.out.println(result ? "Yes" : "No");
    }

    public boolean dfs(int[] nums, boolean[] visited, int k, int targetSum, int currSum, int index) {
        if (k == 0) return true;
        if (targetSum == currSum)
            return dfs(nums, visited, k - 1, targetSum, 0, nums.length - 1);
        for (int i = index; i >= 0; i--) {
            if (visited[i]) continue;
            if (i + 1 < nums.length && nums[i] == nums[i + 1] && !visited[i + 1]) continue;
            if (currSum + nums[i] > targetSum) continue;
            visited[i] = true;
            if (dfs(nums, visited, k, targetSum, currSum + nums[i], i - 1)) return true;
            visited[i] = false;
        }
        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) return false;
        int targetSum = sum / 4;
        return dfs(matchsticks, new boolean[matchsticks.length], 4, targetSum, 0, matchsticks.length - 1);
    }
}
