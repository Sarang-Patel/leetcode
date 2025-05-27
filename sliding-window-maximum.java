# Sliding Window Maximum
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || k <= 0) return new int[0];
        
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int right = 0; right < nums.length; right++) {
            
            while(!dq.isEmpty() && dq.peekFirst() <= right - k) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }

            dq.offerLast(right);

            if(right >= k - 1) {
                res[right - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}