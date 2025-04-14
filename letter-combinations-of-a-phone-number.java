# Letter Combinations of a Phone Number
class Solution {
    String digits;
    int len;
    List<String> result = new ArrayList<>();
    String[] letterMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        this.len = digits.length();

        backtrack(0, new StringBuilder());
        return result;
    }

    public void backtrack(int index, StringBuilder sb) {
        if(sb.length() == len) {
            result.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);

        for(char c : letterMap[(digit - '0') - 2].toCharArray()) {
            sb.append(c);
            backtrack(index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}