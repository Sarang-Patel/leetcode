# Longest Repeating Character Replacement
class Solution {
    public int characterReplacement(String s, int k) {
        int back = 0;
        int front = 0;

        int max = 0;
        int maxfreq = 0;

        if(s.length() == 1) return 1;
        if(s.length() == k) return k;

        char[] arr = s.toCharArray();
        int[] freq = new int[26];

        while(front < arr.length) {
            freq[arr[front] - 'A']++;

            maxfreq = Math.max(maxfreq, freq[arr[front] - 'A']);

            if(front - back + 1 - maxfreq > k) {
                freq[arr[back] - 'A']--;
                back++;
            } 

            max = Math.max(max, front - back + 1);
            front++;
        }

        return max;
    }
}