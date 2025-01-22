# Koko Eating Bananas
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;
            int hoursNeed = hoursNeeded(piles, mid);
            if (hoursNeed <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int hoursNeeded(int[] piles, int mid) {
        int count = 0;

        for (int pile : piles) {
            count += (int) Math.ceil((double) pile / mid);
        }

        return count;
    }

    public int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;

        for (int i : piles) {
            max = Math.max(max, i);
        }

        return max;
    }
}