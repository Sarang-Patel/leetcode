# Interleaving String
class Solution {
    String s3;
    String s2;
    String s1;

    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        this.s3 = s3;
        this.s1 = s1;
        this.s2 = s2;
        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, 0);
    }

    public boolean dfs(int i, int j) {
        if(memo[i][j]!=null) return memo[i][j];

        if(i == s1.length() && j == s2.length()) return true;

        int k = i+j;
        boolean valid = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            valid = valid | dfs(i+1, j);
        } 
        if(!valid && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            valid = valid | dfs(i, j + 1);
        } 

        memo[i][j] = valid;

        return valid;
    }
}