# String to Integer (atoi)
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;

        boolean positive = true;
        int i = 0;

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        if(s.charAt(0) == '-') {positive = false; i = 1;}
        if(s.charAt(0) == '+') {i = 1;}

        int res = 0;

        for(; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!Character.isDigit(c)) break;

            if (res > Integer.MAX_VALUE / 10 ||
               (res == Integer.MAX_VALUE / 10 && (c - '0') > 7)) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res *= 10;
            res += c - '0';
        }

        if(!positive) return -res;
        return res;
    }
}