# Number of Islands
class Solution {
    int count = 0;

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;

        if(i < 0 || i > rows - 1 || j < 0 || j > col - 1 || grid[i][j] == '0')
        return;

        grid[i][j] = '0';

        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);

    }
}