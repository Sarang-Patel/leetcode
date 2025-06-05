# Remove Duplicates from Sorted Array
class Solution {
    public int removeDuplicates(int[] nums) {
        int ahead = 1;
        int behind = 0;

        while(ahead < nums.length) {
            if(nums[ahead] == nums[behind]) {
                ahead++;
            }else {
                nums[++behind] = nums[ahead++];
            }
        }

        return behind+1;
    }
}