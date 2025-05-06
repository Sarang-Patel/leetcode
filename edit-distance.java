# Edit Distance
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Always make word2 the shorter one (optional optimization)
        if (n > m) {
            return minDistance(word2, word1);
        }

        int[] dp = new int[n + 1];

        // Base case: converting "" -> word2
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int prev = dp[0];  // dp[i-1][0]
            dp[0] = i;         // dp[i][0]

            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // store dp[i-1][j]

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = 1 + Math.min(
                        prev,              // replace
                        Math.min(dp[j],    // delete
                                 dp[j - 1])// insert
                    );
                }

                prev = temp; // move diagonal forward
            }
        }

        return dp[n];
    }
}
