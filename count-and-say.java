# Count and Say
class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";

        return count(countAndSay(n-1));
    }

    public String count(String s) {
        StringBuilder sb = new StringBuilder();
        int c = 0;

        for(int i = 0; i < s.length(); i++) {
            c += 1;
            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) continue;

            sb.append(c).append(s.charAt(i));
            c = 0;
        }

        return sb.toString();
    }
}