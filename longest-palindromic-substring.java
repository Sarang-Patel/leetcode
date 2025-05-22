# Longest Palindromic Substring
class Solution {
    public String longestPalindrome(String s) {

        int resLeft = 0;
        int resRight = 0;

        for (int i = 0; i < s.length(); i++) {

            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resRight - resLeft + 1) {
                    resLeft = left;
                    resRight = right;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resRight - resLeft + 1) {
                    resLeft = left;
                    resRight = right;
                }
                left--;
                right++;
            }
        }

        return s.substring(resLeft, resRight + 1);
    }
}
