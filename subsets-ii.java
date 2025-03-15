# Subsets II
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, used, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, boolean[] used, int start, List<Integer> path) {
        res.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            if(used[i]) continue;

            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, i + 1, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}