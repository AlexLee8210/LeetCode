class Solution {
    private int[][] dirs = new int[][]{{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {-1, -2}, {-2, -1}, {1, -2}, {-2, 1}};
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[601][601];
        q.offer(new int[]{0, 0});

        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                if (vis[pos[0] + 300][pos[1] + 300]) continue;
                vis[pos[0] + 300][pos[1] + 300] = true;
                for (int[] dir : dirs) {
                    int newX = pos[0] + dir[0];
                    int newY = pos[1] + dir[1];

                    if (newX == x && newY == y) return step;
                    q.offer(new int[]{newX, newY});
                }
            }
        }

        return step;
    }
}