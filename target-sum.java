# Target Sum
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums) sum += i;

        if((sum + target) % 2 == 1 || Math.abs(target) > sum) return 0;

        int P = (sum + target) / 2;

        int[] dp = new int[P+1];
        dp[0] = 1;

        for(int num : nums) {
            for(int j = P; j >= num; j--) {
                dp[j] += dp[j-num];
            }
        }

        return dp[P];
    }
}