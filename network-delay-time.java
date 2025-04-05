# Network Delay Time
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> neighbors = new HashMap<>();

        for(int[] edge : times) {
            neighbors.computeIfAbsent(edge[0], m -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] node = pq.poll();

            if(node[1] > dist[node[0]]) continue;

            for(int[] neighbor : neighbors.getOrDefault(node[0], Collections.emptyList())) {
                if(dist[node[0]] + neighbor[1] < dist[neighbor[0]]) {
                    dist[neighbor[0]] = dist[node[0]] + neighbor[1];
                    pq.offer(new int[]{neighbor[0], dist[neighbor[0]]});
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for(int i : dist) {
            if(i == Integer.MAX_VALUE) return -1;
            max = Math.max(max, i);
        }

        return max;
    }
}