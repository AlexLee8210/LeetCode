class Solution {
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private class Pos {
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private class UnionFind {
        int[][][] par;
        int[][] rank;
        
        public UnionFind(int m, int n) {
            par = new int[m][n][2];
            rank = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    par[r][c] = new int[]{r, c};
                    rank[r][c] = 1;
                }
            }
        }

        public int[] find(int[] pos) {
            if (par[pos[0]][pos[1]] == pos) return pos;

            int[] parent = find(par[pos[0]][pos[1]]);
            par[pos[0]][pos[1]] = parent;
            return parent;
        }

        public boolean union(int[] pos1, int[] pos2) {
            int[] parent1 = find(pos1);
            int[] parent2 = find(pos2);
            if (parent1 == parent2) {
                return false;
            } else if (rank[parent1[0]][parent1[1]] < rank[parent2[0]][parent2[1]]) {
                par[parent2[0]][parent2[1]] = parent1;
                rank[parent1[0]][parent1[1]] += rank[parent2[0]][parent2[1]];
            } else {
                par[parent1[0]][parent1[1]] = parent2;
                rank[parent2[0]][parent2[1]] += rank[parent1[0]][parent1[1]];
            }
            return true;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        boolean[][] grid = new boolean[m][n];
        ArrayList<Integer> islands = new ArrayList<>();
        UnionFind uf = new UnionFind(m, n);

        islands.add(1);
        grid[positions[0][0]][positions[0][1]] = true;

        for (int i = 1; i < positions.length; i++) {
            int[] pos = positions[i];
            if (grid[pos[0]][pos[1]]) {
                islands.add(islands.get(i - 1));
                continue;
            }
            grid[pos[0]][pos[1]] = true;

            int nIslands = islands.get(i - 1) + 1;
            for (int[] dir : dirs) {
                int newR = pos[0] + dir[0];
                int newC = pos[1] + dir[1];
                if (!isValid(newR, newC, m, n)) continue;
                if (grid[newR][newC] == false) continue;

                if (uf.union(new int[]{newR, newC}, pos)) {
                    nIslands--;
                }
            }

            islands.add(nIslands);
        }
        return islands;
    }

    private boolean isValid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}