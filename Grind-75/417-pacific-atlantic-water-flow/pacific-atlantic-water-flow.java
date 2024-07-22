class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private class Pair {
        int x, y;
        public Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Queue<Pair> pacific = new LinkedList<>();
        Queue<Pair> atlantic = new LinkedList<>();
        boolean[][] pVis = new boolean[m][n];
        boolean[][] aVis = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            pacific.offer(new Pair(r, 0));
            atlantic.offer(new Pair(r, n - 1));
        }
        for (int c = 0; c < n; c++) {
            pacific.offer(new Pair(0, c));
            atlantic.offer(new Pair(m - 1, c));
        }
        
        while (!pacific.isEmpty()) {
            Pair p = pacific.poll();
            int r = p.x, c = p.y;
            if (pVis[r][c]) continue;
            pVis[r][c] = true;
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (heights[nr][nc] < heights[r][c]) continue;
                pacific.offer(new Pair(nr, nc));
            }
        }
        
        while (!atlantic.isEmpty()) {
            Pair p = atlantic.poll();
            int r = p.x, c = p.y;
            if (aVis[r][c]) continue;
            aVis[r][c] = true;
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (heights[nr][nc] < heights[r][c]) continue;
                atlantic.offer(new Pair(nr, nc));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pVis[r][c] && aVis[r][c]) {
                    List<Integer> list = new ArrayList<>(2);
                    list.add(r);
                    list.add(c);
                    res.add(list);
                }
            }
        }
        return res;
    }
}