class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    ++num;
                }
            }
        }

        return num;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            if (grid[point[0]][point[1]] == '0') continue;
            grid[point[0]][point[1]] = '0';
            for (int[] dir : dirs) {
                int[] newPoint = new int[]{point[0] + dir[0], point[1] + dir[1]};
                if (!isValidPoint(newPoint, grid.length, grid[0].length)) continue;
                if (grid[newPoint[0]][newPoint[1]] != '1') continue;

                q.offer(newPoint);
            }
        }
    }

    private boolean isValidPoint(int[] point, int m, int n) {
        return point[0] >= 0 && point[0] < m
            && point[1] >= 0 && point[1] < n;
    }
}