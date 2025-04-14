# N-Queens
import java.util.*;

class Solution {
    List<List<String>> result = new ArrayList<>();
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        backtrack(0, 0, 0, 0, new int[n]);
        return result;
    }

    private void backtrack(int row, int cols, int diag1, int diag2, int[] board) {
        if (row == n) {
            result.add(build(board));
            return;
        }

        int available = ((1 << n) - 1) & ~(cols | diag1 | diag2);

        while (available != 0) {
            int bit = available & -available;
            available -= bit;

            int col = Integer.numberOfTrailingZeros(bit);
            board[row] = col;

            backtrack(
                row + 1,
                cols | bit,
                (diag1 | bit) << 1,
                (diag2 | bit) >> 1,
                board
            );
        }
    }

    private List<String> build(int[] board) {
        List<String> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[board[i]] = 'Q';
            b.add(new String(row));
        }
        return b;
    }
}
