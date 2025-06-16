# Next Permutation
class Solution {
    public void nextPermutation(int[] nums) {
        
        int pivot = -1;

        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }

        if(pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int right = pivot + 1;
        int bigger = Integer.MAX_VALUE;
        int bigIndex = nums.length - 1;

        while(bigIndex >= 0) {
            if(nums[bigIndex] > nums[pivot]) {
                break;
            }
            bigIndex--;
        }

        int temp = nums[pivot];
        nums[pivot] = nums[bigIndex];
        nums[bigIndex] = temp;

        reverse(nums, pivot + 1, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }


    }
}