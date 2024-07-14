class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            ArrayList<Integer> mht = new ArrayList<>();
            mht.add(0);
            return mht;
        }

        ArrayList<Integer>[] adj = new ArrayList[n];
        int[] deg = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            deg[edge[0]]++;
            deg[edge[1]]++;
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (int i = leaves.size() - 1; i >= 0; i--) {
                int leaf = leaves.get(i);
                int neighbor = adj[leaf].get(0);
                adj[neighbor].remove(new Integer(leaf));
                deg[neighbor]--;
                if (deg[neighbor] == 1) newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
    // public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    //     ArrayList<Integer>[] graph = new ArrayList[n];
    //     int[][] dp = new int[n][n];

    //     for (int[] edge : edges) {
    //         if (graph[edge[0]] == null) {
    //             graph[edge[0]] = new ArrayList<>();
    //         }
    //         graph[edge[0]].add(edge[1]);
    //         dp[edge[0]][edge[1]] = 1;
    //         if (graph[edge[1]] == null) {
    //             graph[edge[1]] = new ArrayList<>();
    //         }
    //         graph[edge[1]].add(edge[0]);
    //         dp[edge[1]][edge[0]] = 1;
    //     }

    //     ArrayList<Integer> res = new ArrayList<>();
    //     int minHeight = Integer.MAX_VALUE;
    //     for (int i = 0; i < n; i++) {
    //         // find the max distance from i to any node
    //         int height = Integer.MIN_VALUE;
    //         for (int j = 0; j < n; j++) {
    //             if (i == j) continue;
    //             if (dp[i][j] == 0) {
    //                 height = Math.max(height, bfs(graph, dp, i, j));
    //             } else {
    //                 height = Math.max(height, dp[i][j]);
    //             }
    //         }
    //         if (height < minHeight) {
    //             minHeight = height;
    //             res = new ArrayList<>();
    //             res.add(i);
    //         } else if (height == minHeight) {
    //             res.add(i);
    //         }
    //     }
    //     return res;
    // }

    // private int bfs(ArrayList<Integer>[] graph, int[][] dp, int src, int dest) {
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(src);
    //     while (!q.isEmpty()) {
    //         int node = q.poll();
    //         if (dp[node][dest] != 0) {
    //             dp[src][dest] = dp[src][node] + dp[node][dest];
    //             return dp[src][dest];
    //         }
    //         for (int neighbor : graph[node]) {
    //             if (dp[src][neighbor] == 0) {
    //                 dp[src][neighbor] = dp[src][node] + 1;
    //             } else {
    //                 dp[src][neighbor] = Math.min(dp[src][node] + 1, dp[src][neighbor]);
    //             }
    //             if (neighbor == dest) {
    //                 return dp[src][dest];
    //             }
    //             q.offer(neighbor);
    //         }
    //     }
    //     return -1;
    // }
}