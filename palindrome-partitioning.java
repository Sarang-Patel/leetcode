# Palindrome Partitioning
class Solution {
    List<List<String>> result = new ArrayList<>();
    String s;
    int len;
    public List<List<String>> partition(String s) {
        this.s = s;
        this.len = s.length();

        backtrack(0, new ArrayList<>());
        return result;
    }

    public void backtrack(int start, List<String> path) {
        if(start == len) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = start + 1; i <= len; i++) {
            String slice = s.substring(start, i);
            if(check(slice)) {
                path.add(slice);
                backtrack(i, path);
                path.remove(path.size() - 1);
            }else{
                continue;
            }
        }
    }

    public boolean check(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}