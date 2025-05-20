# Decode Ways
class Solution {
    public int numDecodings(String s) {

        if(s== null || s.charAt(0) == '0')
        return 0;

        if(s.length() == 1) return 1;

        int prev = 1;
        int curr = 1;

        for(int i = 1; i < s.length(); i++) {
            int temp = 0;

            int one = s.charAt(i) - '0';
            int two = Integer.parseInt(s.substring(i - 1, i + 1));

            if(one >= 1 && one <= 9) {
                temp += curr;
            } 

            if(two >= 10 && two <= 26) {
                temp += prev;
            }

            prev = curr;
            curr = temp;
        }

        return curr;
    }
}