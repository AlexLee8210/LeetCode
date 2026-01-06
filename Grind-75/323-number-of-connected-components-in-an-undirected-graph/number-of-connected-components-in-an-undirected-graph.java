class Solution {
    private class UnionFind {
        int[] par;
        int[] size;

        public UnionFind(int n) {
            par = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                par[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (par[x] == x) return x;

            int res = find(par[x]);
            par[x] = res;
            return res;
        }

        public int union(int a, int b) {
            if (a == b) return a;
            if (size[a] < size[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            int root = find(a);
            par[find(b)] = root;
            return root;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        int count = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int root = uf.find(i);
            if (vis[root]) continue;
            vis[root] = true;
            ++count;
        }
        return count;
    }
}