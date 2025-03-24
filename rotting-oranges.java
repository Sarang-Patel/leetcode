# Rotting Oranges
class Solution {
    Queue<Pair<Integer, Integer>> q;
    int time;
    int fresh;

    public int orangesRotting(int[][] grid) {
        time = 0;
        q = new LinkedList<>();

        int rows = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair<>(i, j));
                    grid[i][j] = 0;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        bfs(grid);

        if (fresh > 0)
            return -1;

        return time;
    }

    public void bfs(int[][] grid) {

        while (!q.isEmpty()) {
            int level = q.size();
            boolean rotThisTime = false;

            int rows = grid.length;
            int col = grid[0].length;

            while (level > 0) {
                Pair<Integer, Integer> orange = q.poll();
                if (orange.getValue() + 1 < col && grid[orange.getKey()][orange.getValue() + 1] == 1) {
                    q.offer(new Pair<>(orange.getKey(), orange.getValue() + 1));
                    fresh--;
                    grid[orange.getKey()][orange.getValue() + 1] = 2;
                    rotThisTime = true;

                }
                if (orange.getValue() - 1 >= 0 && grid[orange.getKey()][orange.getValue() - 1] == 1) {
                    q.offer(new Pair<>(orange.getKey(), orange.getValue() - 1));
                    fresh--;
                    grid[orange.getKey()][orange.getValue() - 1] = 2;
                    rotThisTime = true;

                }
                if (orange.getKey() - 1 >= 0 && grid[orange.getKey() - 1][orange.getValue()] == 1) {
                    q.offer(new Pair<>(orange.getKey() - 1, orange.getValue()));
                    fresh--;
                    grid[orange.getKey() - 1][orange.getValue()] = 2;
                    rotThisTime = true;

                }
                if (orange.getKey() + 1 < rows && grid[orange.getKey() + 1][orange.getValue()] == 1) {
                    q.offer(new Pair<>(orange.getKey() + 1, orange.getValue()));
                    fresh--;
                    grid[orange.getKey() + 1][orange.getValue()] = 2;
                    rotThisTime = true;

                }
                level--;
            }

            if(rotThisTime) time++;
        }

    }
}