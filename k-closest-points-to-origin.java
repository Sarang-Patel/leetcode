# K Closest Points to Origin
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, int[]>> q = new PriorityQueue<>(Comparator.comparingDouble(p -> p.getKey()));

        for(int[] i: points) {
            double dist = Math.pow(i[0], 2) + Math.pow(i[1], 2);

            q.add(new Pair<>(dist, i));
        }

        int[][] ans = new int[k][];

        for (int i = 0; i < k; i++) {
            ans[i] = q.poll().getValue();
        }

        return ans;
    }
}