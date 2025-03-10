class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]);

        int total = 0;

        for (int r = 0; r < m; ++r) {
            pq.offer(new int[]{r, 0});
            pq.offer(new int[]{r, n - 1});
        }
        for (int c = 1; c < n - 1; ++c) {
            pq.offer(new int[]{0, c});
            pq.offer(new int[]{m - 1, c});
        }

        boolean[][] vis = new boolean[m][n];
        int height = 0;

        while(!pq.isEmpty()) {
            int[] cell = pq.poll();
            if (vis[cell[0]][cell[1]]) continue;
            vis[cell[0]][cell[1]] = true;
            
            if (height < heightMap[cell[0]][cell[1]]) {
                height = heightMap[cell[0]][cell[1]];
            } else {
                total += height - heightMap[cell[0]][cell[1]];
                heightMap[cell[0]][cell[1]] = height;
            }

            for (int[] dir : dirs) {
                int nextRow = cell[0] + dir[0];
                int nextCol = cell[1] + dir[1];

                if (!inBounds(nextRow, nextCol, m, n)) continue;

                pq.offer(new int[]{nextRow, nextCol});
            }
        }

        return total;
    }

    private boolean inBounds(int r, int c, int m, int n) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}