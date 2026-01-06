class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                max = Math.max(area(grid, r, c), max);
            }
        }
        return max;
    }

    private int area(int[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];
            if (grid[r][c] == 0) continue;
            grid[r][c] = 0;
            ++area;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (grid[nr][nc] == 0) continue;

                queue.offer(new int[]{nr, nc});
            }
        }

        return area;
    }
}