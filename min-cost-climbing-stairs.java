# Min Cost Climbing Stairs
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] curr = new int[cost.length + 1];
        curr[0] = cost[0];
        curr[1] = cost[1];
        for(int i = 2; i<=cost.length; i++) {
            int price = (i == cost.length) ? 0: cost[i];
            curr[i] = Math.min(curr[i-1], curr[i-2]) + price; 
        }

        return curr[cost.length];
    }
}