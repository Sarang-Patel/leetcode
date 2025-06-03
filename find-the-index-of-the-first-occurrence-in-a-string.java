# Find the Index of the First Occurrence in a String
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        if (m == 0) return 0;  // edge case: empty needle
        
        for (int i = 0; i <= n - m; i++) { // check starting at i
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) return i; // full match
        }
        
        return -1; // no match
    }
}
