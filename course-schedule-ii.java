# Course Schedule II
class Solution {
    private List<Integer> result;
    private boolean[] visited;
    private boolean[] onPath;
    private HashMap<Integer, List<Integer>> graph;

    public int[] findOrder(int numCourses, int[][] pre) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        result = new ArrayList<>();
        graph = new HashMap<>();


        for(int[] p: pre) {
            graph.putIfAbsent(p[1], new ArrayList<>());
            graph.get(p[1]).add(p[0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(!dfs(i)) {
                    return new int[0];
                }
            }
        }

        Collections.reverse(result);
        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            res[i] = result.get(i);
        }

        return res;

    }

    public boolean dfs(int node) {
        if(onPath[node]) return false;

        if(visited[node]) return true;

        onPath[node] = true;

        for(int i: graph.getOrDefault(node, new ArrayList<>())) {
            if(!dfs(i)) return false;
        }

        onPath[node] = false;
        visited[node] = true;
        result.add(node);
        return true;
    }
}