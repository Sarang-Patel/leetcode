# House Robber II
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] row1 = Arrays.copyOfRange(nums, 0, n-1); 
        int[] row2 = Arrays.copyOfRange(nums, 1, n);

        int cost1 = calc(row1);
        int cost2 = calc(row2);

        return Math.max(cost1, cost2);
    }

    public int calc(int[] row) {
        int n = row.length;
        row[1] = Math.max(row[0], row[1]);

        for(int i = 2; i < n; i++) {
            row[i] = Math.max(row[i] + row[i-2], row[i-1]);
        }

        return row[n-1];        
    }

}