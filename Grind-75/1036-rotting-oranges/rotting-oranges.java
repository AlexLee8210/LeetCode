class Solution {
    private final int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    ++fresh;
                }
            }
        }

        int minutes = 0;
        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    --fresh;
                    queue.offer(new int[]{nr, nc});
                }
            }
            ++minutes;
        }

        return fresh == 0 ? minutes : -1;
    }
}