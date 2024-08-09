class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> pq = new LinkedList<>();

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] vis = new boolean[m][n];
        int[] pos = null;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '*') {
                    pos = new int[]{r, c, 0};
                    break;
                }
            }
            if (pos != null) break;
        }

        pq.offer(pos);

        int step = 0;
        while (!pq.isEmpty()) {
            int len = pq.size();
            step++;
            for (int i = 0; i < len; i++) {
                pos = pq.poll();
                if (vis[pos[0]][pos[1]]) continue;
                vis[pos[0]][pos[1]] = true;

                for (int[] dir : dirs) {
                    int r = pos[0] + dir[0];
                    int c = pos[1] + dir[1];
                    if (!isValid(r, c, m, n)) continue;

                    if (grid[r][c] == '#') {
                        return step;
                    } else if (grid[r][c] != 'X') {
                        pq.offer(new int[]{r, c});
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}