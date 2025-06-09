# Zigzag Conversion
class Solution {
    public String convert(String s, int n) {
        if(n == 1 || s.length() <= n) return s;

        StringBuilder[] rows = new StringBuilder[n];
        
        for(int i = 0; i < n; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        for(char c: s.toCharArray()) {
            rows[currRow].append(c);

            if(currRow == 0 || currRow == n - 1) {
                goingDown = !goingDown;
            }

            currRow += goingDown ? 1: -1;
        }

        StringBuilder res = new StringBuilder();

        for(StringBuilder row: rows) {
            res.append(row);
        }

        return res.toString();
    }
}