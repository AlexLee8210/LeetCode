class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int[] edge : edges) {
            if (adj[edge[0]] == null) adj[edge[0]] = new ArrayList<>();
            if (adj[edge[1]] == null) adj[edge[1]] = new ArrayList<>();
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        } 

        Set<Integer> vis = new HashSet<>();
        return dfs(0, -1, adj, vis) && vis.size() == n;
    }

    private boolean dfs(int cur, int prev, List<Integer>[] adj, Set<Integer> vis) {
        if (vis.contains(cur)) return false;
        vis.add(cur);
        if (adj[cur] == null) return true;
        for (int neighbor : adj[cur]) {
            if (neighbor == prev) continue;
            if (!dfs(neighbor, cur, adj, vis)) return false;
        }
        return true;
    }
}