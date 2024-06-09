class Solution {
    private class Point {
        public int x, y;
        public Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair<Point, Integer>> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) q.offer(new Pair<>(new Point(r, c), 0));
            }
        }
        bfs(grid, q);
        int max = 0;
        
        // for (int r = 0; r < m; r++) {
        //     System.out.println(Arrays.toString(grid[r]));
        // }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) return -1;
                max = Math.max(grid[r][c] - 2, max);
            }
        }
        return max;
    }

    private void bfs(int[][] grid, Queue<Pair<Point, Integer>> q) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        while (!q.isEmpty()) {
            Pair<Point, Integer> p = q.poll();
            int r = p.getKey().x;
            int c = p.getKey().y;
            int minToRot = p.getValue();
            if (!isValid(m, n, r, c)) continue;
            if (grid[r][c] == 0) continue;
            // if (grid[r][c] <= 2) {
            if (!vis[r][c] && grid[r][c] <= 2) {
                vis[r][c] = true;
                grid[r][c] = grid[r][c] == 1 ? 2 + minToRot : 2;
                q.offer(new Pair<>(new Point(r - 1, c), minToRot + 1));
                q.offer(new Pair<>(new Point(r, c - 1), minToRot + 1));
                q.offer(new Pair<>(new Point(r + 1, c), minToRot + 1));
                q.offer(new Pair<>(new Point(r, c + 1), minToRot + 1));
            }
        }
    }

    private boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }
}