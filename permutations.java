# Permutations
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>());
        return res;    
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> path) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}