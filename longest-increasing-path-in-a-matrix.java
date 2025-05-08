# Longest Increasing Path in a Matrix
class Solution {
    int max = Integer.MIN_VALUE;
    int[][] matrix;
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    int m;
    int n;

    Integer[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;

        memo = new Integer[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }

        return max;

    }

    public int dfs(int row, int col) {
        if (memo[row][col] != null)
            return memo[row][col];
        int total = 1;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                continue;

            if (matrix[row][col] < matrix[newRow][newCol])
                total = Math.max(total, dfs(newRow, newCol) + 1);
        }

        memo[row][col] = total;
        return total;
    }
}