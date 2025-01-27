# Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        if(s.length() == 0 || s == null) return 0;
        if(s.length() == 1) return 1;

        char[] arr = s.toCharArray();

        int front = 0;
        int back = 0;

        while(front < arr.length) {
            if(set.add(arr[front])) {
                max = Math.max(max, front - back);
                front++;
            }else{
                set.remove(arr[back]);
                back++;
            }
        }

        return max + 1;
    }
}