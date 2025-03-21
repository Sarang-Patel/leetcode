# Max Area of Island
class Solution {
    int maxArea = 0;
    int count = 0;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;

        visited = new boolean[rows][col];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j, grid);
                    maxArea = Math.max(count, maxArea);
                }
            }
        }

        return maxArea;
    }

    public void dfs(int i, int j, int[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;

        if (i < 0 || i > rows - 1 || j < 0 || j > col - 1 || visited[i][j] || grid[i][j] == 0)
            return;

        count++;
        visited[i][j] = true;

        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);

    }
}