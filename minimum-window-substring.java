# Minimum Window Substring
class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> tfreq = new HashMap<>();
        HashMap<Character, Integer> windowfreq = new HashMap<>();

        for(char c: t.toCharArray()) {
            tfreq.put(c, tfreq.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;

        int minLen = Integer.MAX_VALUE;

        int start = 0;
        int formed = 0;

        int required = tfreq.size();

        
        while(right < s.length()) {
            char element = s.charAt(right);
            windowfreq.put(element, windowfreq.getOrDefault(element, 0) + 1);

            if(windowfreq.get(element).equals(tfreq.get(element))) {
                formed++;
            }

            while(left <= right && formed == required) {

                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);
                windowfreq.put(remove, windowfreq.get(remove) - 1);
                
                if(tfreq.containsKey(remove) && windowfreq.get(remove) < tfreq.get(remove)) {
                    formed--;
                }

                left++;

            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

    }
}