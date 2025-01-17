# Find Minimum in Rotated Sorted Array
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        if(nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];

            if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];

            if(nums[mid] < nums[nums.length - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}