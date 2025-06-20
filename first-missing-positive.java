# First Missing Positive
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int i : nums) {
            if(i > 0 && i <= nums.length) {
                map.put(i, 1);
                max = i > max ? i : max;
            }
        }

        for(int i = 1; i <= nums.length; i++) {
            if(!map.containsKey(i)) return i;            
        }

        return max + 1;
    }
}