# Insert Interval
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while(i < intervals.length) {
            int[] interval = intervals[i];
            if(interval[1] < newInterval[0]) {
                list.add(interval);
                i++;
            }else{
                break;
            }
        }

        int[] merge = newInterval;
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            merge[0] = Math.min(merge[0], intervals[i][0]);
            merge[1] = Math.max(merge[1], intervals[i][1]);
            i++;
        }

        list.add(merge);

        while(i < intervals.length) {
            int[] interval = intervals[i];

            list.add(interval);
            i++;
        }

        int[][] res = new int[list.size()][2];

        for(int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }

        return res;

    }
}