# Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = Math.abs(right - left);
            int area = minHeight * width;
            
            if(area > max) {
                max = area;
            }

            while(left < right && height[left]<=minHeight) left++;
            while(left < right && height[right]<=minHeight) right--;

        }

        return max;
    }
}