# Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = prices[0];

        for(int right = 1; right < prices.length; right++) {
            max = Math.max(max, prices[right] - left);
            left = Math.min(left, prices[right]);
        }

        return max;
    }
}