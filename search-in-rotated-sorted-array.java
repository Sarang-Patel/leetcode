# Search in Rotated Sorted Array
class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) return 0;
        if(nums[nums.length - 1] == target) return nums.length - 1;


        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] >= nums[left]) {
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}