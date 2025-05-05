# Regular Expression Matching
class Solution {
    Boolean[][] memo;
    int m;
    int n;
    String s;
    String p;

    public boolean isMatch(String s, String p) {
        this.m = s.length();
        this.n = p.length();
        this.s = s;
        this.p = p;

        this.memo = new Boolean[m + 1][n + 1];

        return dfs(0, 0);
    }

    public boolean dfs(int i, int j) {
        if (j == n) {
            return i == m;
        }

        if (memo[i][j] != null)
            return memo[i][j];

        boolean currMatch = (i < m) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < n && p.charAt(j + 1) == '*') {
            memo[i][j] = dfs(i, j + 2) || (currMatch && dfs(i + 1, j));
        } else {
            memo[i][j] = currMatch && dfs(i + 1, j + 1);
        }

        return memo[i][j];

    }
}