class Solution {
    private class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int n) {
            if (parent[n] == n) return n;

            int par = find(parent[n]);
            parent[n] = par;
            return par;
        }

        public boolean union(int a, int b) {
            int par1 = find(a);
            int par2 = find(b);

            if (par1 == par2) {
                return false;
            } else if (rank[par1] < rank[par2]) {
                parent[par1] = par2;
                rank[par2] += rank[par1];
            } else {
                parent[par2] = par1;
                rank[par1] += rank[par2];
            }
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                n--;
            }
        }
        return n;
    }
}