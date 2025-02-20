# Two Sum II - Input Array Is Sorted
class Solution {
    public int[] twoSum(int[] n, int target) {
        int left = 0;
        int right = n.length - 1;

        while(left < right) {
            if(n[left] + n[right] == target) return new int[]{left + 1, right + 1};

            else if(n[left] + n[right] < target) {
                left++;
                continue;
            }else{
                right--;
                continue;
            }
        }

        return new int[2];
    }
}