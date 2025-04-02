# Swim in Rising Water
class Solution {
    int[][] grid;
    boolean[][] visited;
    int n;
    public int swimInWater(int[][] grid) {
        this.grid = grid;
        this.n = grid.length - 1;

        int left = 0;
        int right = findMax();

        while(left < right) {
            int mid = left + (right - left) / 2;
            this.visited = new boolean[n + 1][n + 1];

            if(canReach(mid)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;

    }

    public int findMax() {
        int max = -1;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }

    public boolean canReach(int speed) {
        if (grid[0][0] > speed) return false;
        visited[0][0] = true;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        ArrayDeque<int[]> pq = new ArrayDeque<>(); 
        
        pq.offer(new int[]{grid[0][0], 0, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            for(int[] dir: dirs) {
                int x = curr[1] + dir[0];
                int y = curr[2] + dir[1];

                if(x < 0 || y < 0 || x > n || y > n || visited[x][y] || grid[x][y] > speed) continue;
                if(x == n && y == n) return true;
                pq.offer(new int[]{grid[x][y], x, y});
                visited[x][y] = true;
            }
        }

        return false;
    }
}