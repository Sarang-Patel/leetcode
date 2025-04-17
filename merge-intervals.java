# Merge Intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();

        int[] prev = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            int[] consider = intervals[i];
            if(prev[1] < consider[0]) {
                list.add(prev);
                prev = consider;
            }else{
                int[] merge = prev;
                merge[0] = Math.min(merge[0], consider[0]);
                merge[1] = Math.max(merge[1], consider[1]);
                prev = merge;
            }
        }

        list.add(prev);

        int[][] res = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}