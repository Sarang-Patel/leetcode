# Word Search
class Solution {
    private char[][] board;
    private String word;
    private boolean[][] seen;
    private int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int m = board.length;
        int n = board[0].length;

        this.seen = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(backtrack(i, j, 0)) return true;
            }
        }

        return false;
    }

    public boolean backtrack(int row, int col, int idx) {
        if(idx == word.length()) return true;

        if(row < 0 || col < 0 || row == board.length || col == board[0].length) return false;

        if(seen[row][col] || board[row][col] != word.charAt(idx)) return false;

        seen[row][col] = true;

        for(int[] dirs : DIRS) {
            if(backtrack(row + dirs[0], col + dirs[1], idx + 1)) return true;
        }

        seen[row][col] = false;
        return false;




    }
}