class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[0].length; c++) {
                if (rooms[r][c] == 0) {
                    bfs(rooms, r, c);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                for (int[] dir : dirs) {
                    int newR = pos[0] + dir[0];
                    int newC = pos[1] + dir[1];

                    if (!isValid(newR, newC, rooms)) continue;
                    if (rooms[newR][newC] == -1) continue;
                    if (rooms[newR][newC] <= dist) continue;

                    rooms[newR][newC] = dist;
                    q.offer(new int[]{newR, newC});
                }
            }
        }
    }

    private boolean isValid(int r, int c, int[][] rooms) {
        return r >= 0 && r < rooms.length && c >= 0 && c < rooms[r].length;
    }
}