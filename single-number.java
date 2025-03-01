# Single Number
class Solution {
    public int singleNumber(int[] nums) {
        int s = 0;
        for(int i : nums) {
            s = s ^ i;
        }

        return s;
    }
}