class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        ArrayList<HashSet<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new HashSet<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int dest = graph.get(leaf).iterator().next();
                graph.get(dest).remove(leaf);
                if (graph.get(dest).size() == 1) newLeaves.add(dest);
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