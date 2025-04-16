# Non-overlapping Intervals
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int prevEnd = intervals[0][1];
        int count = 1;

        for(int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if(prevEnd > curr[0]) {
                continue;
            }else {
                prevEnd = curr[1];
                count++;
            }
        }

        return intervals.length - count;
    }
}