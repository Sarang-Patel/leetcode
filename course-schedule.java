# Course Schedule
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] group : prerequisites) {
            adjList.putIfAbsent(group[1], new ArrayList<>());

            adjList.get(group[1]).add(group[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        boolean flag = true;

        for (int i = 0; i < numCourses; i++) {
            flag = dfs(i, adjList, visited, onPath);
            if (!flag)
                return false;
        }

        return flag;

    }

    public boolean dfs(int i, HashMap<Integer, List<Integer>> adjList, boolean[] visited, boolean[] onPath) {
        if (onPath[i])
            return false;
        if (visited[i])
            return true;

        onPath[i] = true;

        if (adjList.containsKey(i)) {
            for (int neighbor : adjList.get(i)) {
                if(!dfs(neighbor, adjList, visited, onPath)) {
                    return false;
                }
            }
        }

        visited[i] = true;
        onPath[i] = false;
        return true;

    }
}