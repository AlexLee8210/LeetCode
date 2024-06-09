class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int num = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '0') {
                    continue;
                }
                if (traverse(grid, r, c, vis)) {
                    num++;
                }
            }
        }
        return num;
    }

    private boolean traverse(char[][] grid, int r, int c, boolean[][] vis) {
        if (vis[r][c]) {
            return false;
        }
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(r, c));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> pair = q.poll();
            int row = pair.getKey();
            int col = pair.getValue();
            if (!isValid(grid.length, grid[0].length, row, col)) continue;
            if (grid[row][col] == '0') continue;
            if (vis[row][col]) continue;
            vis[row][col] = true;
            q.offer(new Pair<>(row - 1, col));
            q.offer(new Pair<>(row + 1, col));
            q.offer(new Pair<>(row, col - 1));
            q.offer(new Pair<>(row, col + 1));
        }
        return true;
    }

    private boolean isValid(int m, int n, int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}