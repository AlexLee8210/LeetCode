class Solution {
    private final int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public void wallsAndGates(int[][] rooms) {
        for (int r = 0; r < rooms.length; ++r) {
            for (int c = 0; c < rooms[0].length; ++c) {
                if (rooms[r][c] == 0) bfs(rooms, r, c);
            }
        }
    }

    private void bfs(int[][] rooms, int row, int col) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];

                if (rooms[r][c] < dist) continue;
                if (rooms[r][c] == dist && dist != 0) continue;
                rooms[r][c] = dist;

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (rooms[nr][nc] <= 0) continue;

                    queue.offer(new int[]{nr, nc});
                }
            }

            ++dist;
        }
    }
}