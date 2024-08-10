class Solution {

    public boolean validTree(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        if (!validTree(-1, 0, adj, vis)) return false;
        for (boolean v : vis) {
            if (!v) return false;
        }
        return true;
    }

    private boolean validTree(int par, int cur, ArrayList<Integer>[] adj, boolean[] vis) {
        vis[cur] = true;
        for (int neighbor : adj[cur]) {
            if (neighbor == par) continue;
            if (vis[neighbor]) return false;
            if (!validTree(cur, neighbor, adj, vis)) return false;
        }
        return true;
    }
}