# 3Sum Closest
class Solution {

    int res = Integer.MAX_VALUE;

    int closestDiff = Integer.MAX_VALUE;
    int target;

    int[] nums;

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        this.target = target;
        this.nums = nums;

        for (int i = 0; i < nums.length; i++) {
            calc(i);
            if (closestDiff == 0)
                break;
        }

        return res;
    }

    public void calc(int idx) {
        int left = idx + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[idx] + nums[left] + nums[right];

            int diff = target - sum;

            if (diff == 0) {
                res = sum;
                closestDiff = diff;
                return;
            }

            if (diff < 0 && closestDiff < 0) {
                if (diff > closestDiff) {
                    res = sum;
                    closestDiff = diff;

                }
            }

            if (diff > 0 && closestDiff > 0) {
                if (diff < closestDiff) {
                    res = sum;
                    closestDiff = diff;

                }
            }

            if (Math.abs(diff) < Math.abs(closestDiff)) {
                res = sum;
                closestDiff = diff;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

}