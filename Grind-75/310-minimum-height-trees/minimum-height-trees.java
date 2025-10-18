class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int[] deg = new int[n];
        List<Integer>[] adj = new List[n];

        for (int i = 0; i < edges.length; ++i) {
            ++deg[edges[i][0]];
            ++deg[edges[i][1]];
            if (adj[edges[i][0]] == null) {
                adj[edges[i][0]] = new ArrayList<>();
            }
            if (adj[edges[i][1]] == null) {
                adj[edges[i][1]] = new ArrayList<>();
            }
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (deg[i] <= 1) {
                q.offer(i);
            }
        }

        while(n > 2) {
            int size = q.size();
            n -= size;

            for (int i = 0; i < size; ++i) {
                int leaf = q.poll();
                if (adj[leaf] == null) continue;
                for (int dst : adj[leaf]) {
                    --deg[dst];
                    if (deg[dst] == 1) {
                        q.offer(dst);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            res.add(q.poll());
        }

        return res;
    }
}