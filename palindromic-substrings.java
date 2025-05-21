# Palindromic Substrings
class Solution {
    int count = 0;
    String s;
    public int countSubstrings(String s) {
        this.s = s;
        for (int i = 0; i < s.length(); i++) {

            count++;
            palindrome(i - 1, i + 1);
            palindrome(i, i + 1);
        }

        return count;

    }

    public void palindrome(int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}