class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (grid[r][c] == '1') {
                    ++count;
                    bfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        grid[r][c] = '0';

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(r, c));
        
        while (!q.isEmpty()) {
            Pair<Integer, Integer> pos = q.poll();

            for (int[] dir : dirs) {
                int newR = pos.getKey() + dir[0];
                int newC = pos.getValue() + dir[1];
                
                if (!inBounds(newR, newC, m, n) || grid[newR][newC] == '0') continue;
                grid[newR][newC] = '0';

                q.offer(new Pair<>(newR, newC));
            }
        }
    }

    private boolean inBounds(int r, int c, int m, int n) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}