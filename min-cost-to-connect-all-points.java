# Min Cost to Connect All Points
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((
            a,b) -> Integer.compare(a[1], b[1])
        );

        boolean[] visited = new boolean[points.length];

        int total = 0;
        int edgesUsed = 0;

        Map<Integer, Integer> cache = new HashMap<>();

        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty() && edgesUsed < points.length) {
            int[] point = pq.poll();

            int pointIndex = point[0];
            int pointDist = point[1];

            if(visited[pointIndex]) continue;

            edgesUsed++;
            total += pointDist;
            visited[pointIndex] = true;

            for(int i = 0; i < points.length; i++) {
                if(!visited[i]){
                int dist = Math.abs(points[i][0] - points[pointIndex][0]) + Math.abs(points[i][1] - points[pointIndex][1]);

                if(dist < cache.getOrDefault(i, Integer.MAX_VALUE)) {
                    cache.put(i, dist);
                    pq.offer(new int[]{i, dist});
                }
                }
            } 
        }

        return total;
    }
}