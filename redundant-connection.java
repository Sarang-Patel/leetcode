# Redundant Connection
class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        this.parent = new int[edges.length+1];
        this.rank = new int[edges.length+1];

        for(int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            if(!union(edge[0], edge[1])) return edge;
        }

        return new int[2];
    }

    public int find(int p) {
        if(parent[p] != p) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }

    public boolean union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);

        if(rootp == rootq) return false;

        if(rank[rootp] < rank[rootq]) {
            parent[rootp] = rootq;
        }else if(rank[rootq] < rank[rootp]) {
            parent[rootq] = rootp;
        }else{
            parent[rootp] = rootq;
            rank[rootq]++;
        }

        return true;
    }
}