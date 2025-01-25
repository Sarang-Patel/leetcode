# Longest Consecutive Sequence
class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i: nums) {
            set.add(i);
        }

        int res = 0;

        for(int i: set) {
            if(!set.contains(i - 1)) {
                int count = 1;
                int temp = i;

                while(set.contains(temp + 1)) {
                    count++;
                    temp++;
                }

                res = Math.max(res, count);

            }
        }

        return res;

    }
}