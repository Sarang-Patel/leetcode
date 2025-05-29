# Largest Rectangle in Histogram
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i <= n; i++) {
            int currheight = (i == n ? 0 : heights[i]);

            while(!stack.isEmpty() && currheight < heights[stack.peek()]) {
                int poppedIndex = stack.pop();
                int poppedHeight = heights[poppedIndex];

                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBoundary - 1;

                max = Math.max(max, poppedHeight*width);
            }

            stack.push(i);
        }

        return max;
    }
}