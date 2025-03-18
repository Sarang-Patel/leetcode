# Combination Sum II
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return res;    
    }

    public void backtrack(int[] can, int target, List<Integer> path, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < can.length && can[i] <= target; i++) {

            if (i > start && can[i] == can[i - 1])
                continue;

            path.add(can[i]);

            backtrack(can, target - can[i], path, i + 1);

            path.remove(path.size() - 1);
        }
    }
}