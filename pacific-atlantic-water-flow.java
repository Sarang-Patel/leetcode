# Pacific Atlantic Water Flow
class Solution {
    private Set<Pair<Integer, Integer>> pacific;
    private Set<Pair<Integer, Integer>> atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        pacific = new HashSet<>();
        atlantic = new HashSet<>();

        int m = heights.length;
        int n = heights[0].length;

        for (int col = 0; col < n; col++) {
            dfs(0, col, pacific, heights);
            dfs(m - 1, col, atlantic, heights);
        }

        for (int row = 0; row < m; row++) {
            dfs(row, 0, pacific, heights);
            dfs(row, n - 1, atlantic, heights);
        }

        pacific.retainAll(atlantic);

        List<List<Integer>> res = new ArrayList<>();

        for(Pair<Integer, Integer> cell: pacific) {
            res.add(Arrays.asList(cell.getKey(), cell.getValue()));
        }

        return res;
    }


    public void dfs(int i, int j, Set<Pair<Integer, Integer>> ocean, int[][] grid) {
        Pair<Integer, Integer> cell = new Pair<>(i,j);

        if(ocean.contains(cell))
        return;

        ocean.add(cell);

        int[][] dirs = {{0,1}, {1,0} , {0,-1}, {-1,0}};

        for(int[] dir: dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if(isValid(newRow, newCol, grid.length, grid[0].length) && grid[newRow][newCol] >= grid[i][j]) {
                dfs(newRow, newCol, ocean, grid);
            }
        }
    }

    public boolean isValid(int row, int col, int n, int m) {
        if(row >= n || col >= m || row < 0 || col < 0) return false;
        return true;
    }


}