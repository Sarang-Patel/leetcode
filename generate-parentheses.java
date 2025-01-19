# Generate Parentheses
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);
        return result; 
    }

    public void backtrack(List<String> result, String current, int open, int closed, int max) {
        if(current.length() == max * 2) {
            result.add(current);
            return;
        }

        if(open < max) {
            backtrack(result, current + "(", open+1, closed, max);
        }

        
        if(closed < open) {
            backtrack(result, current + ")", open, closed+1, max);
        }
    }
}