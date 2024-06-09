class Solution {
    private class Point {
        public int x, y;
        public Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{new int[]{-1, 0}, new int[]{0, -1}, new int[]{1, 0}, new int[]{0, 1}};
        Queue<Pair<Point, Integer>> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int freshCount = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) freshCount++;
                if (grid[r][c] == 2) q.offer(new Pair<>(new Point(r, c), 0));
            }
        }
        if (freshCount == 0) return 0;
        int numRotted = 0;
        int min = 0;
        while (!q.isEmpty()) {
            Pair<Point, Integer> p = q.poll();
            int r = p.getKey().x;
            int c = p.getKey().y;
            int minToRot = p.getValue();
            min = Math.max(minToRot, min);
            if (grid[r][c] == 0) continue;
            for (int[] dir : dirs) {
                int newR = r + dir[0], newC = c + dir[1];
                if (isValid(m, n, newR, newC) && grid[newR][newC] == 1) {
                    grid[newR][newC] = 2;
                    q.offer(new Pair<>(new Point(newR, newC), minToRot + 1));
                    numRotted++;
                }
            }
        }
        return numRotted == freshCount ? min : -1;
    }

    private boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }
}