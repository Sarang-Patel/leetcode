# Subsets
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int start, List<Integer> path) {
        res.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++) {
            path.add(nums[i]);

            backtrack(nums, i + 1, path);

            path.remove(path.size() - 1);
        }
    }
}