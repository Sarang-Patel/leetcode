# Surrounded Regions
class Solution {
    int m;
    int n;

    public void solve(char[][] b) {
        this.m = b.length;
        this.n = b[0].length;

        for (int i = 0; i < m; i++) {

            if (b[i][0] == 'O') {
                dfs(i, 0, b);
            }
            if (b[i][n-1] == 'O') {
                dfs(i, n-1, b);
            }

        }

        for (int j = 0; j < n; j++) {

            if (b[0][j] == 'O') {
                dfs(0, j, b);
            }
            if (b[m-1][j] == 'O') {
                dfs(m-1, j, b);
            }

        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(b[i][j] == 'S') b[i][j] = 'O';
                else if(b[i][j] == 'O') b[i][j] = 'X';
            }
        }
    }

    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public void dfs(int i, int j, char[][] b) {
        b[i][j] = 'S';

        for(int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr < 0 || nc < 0 || nr == m || nc == n || b[nr][nc] != 'O') continue;

            dfs(nr, nc, b);
        }
    }   
}