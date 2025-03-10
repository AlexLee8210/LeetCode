class Solution {
    private class Cell {
        int height;
        int row, col;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        PriorityQueue<Cell> pq = new PriorityQueue<>((Cell a, Cell b) -> a.height - b.height);

        int total = 0;

        for (int r = 0; r < m; ++r) {
            pq.offer(new Cell(r, 0, heightMap[r][0]));
            pq.offer(new Cell(r, n - 1, heightMap[r][n - 1]));
        }
        for (int c = 1; c < n - 1; ++c) {
            pq.offer(new Cell(0, c, heightMap[0][c]));
            pq.offer(new Cell(m - 1, c, heightMap[m - 1][c]));
        }

        boolean[][] vis = new boolean[m][n];
        int height = 0;

        while(!pq.isEmpty()) {
            Cell cell = pq.poll();
            if (vis[cell.row][cell.col]) continue;
            vis[cell.row][cell.col] = true;
            
            if (height < heightMap[cell.row][cell.col]) {
                height = heightMap[cell.row][cell.col];
            } else {
                total += height - heightMap[cell.row][cell.col];
                cell.height = height;
            }

            for (int[] dir : dirs) {
                int nextRow = cell.row + dir[0];
                int nextCol = cell.col + dir[1];

                if (!inBounds(nextRow, nextCol, m, n)) continue;

                pq.offer(new Cell(nextRow, nextCol, heightMap[nextRow][nextCol]));
            }
        }

        return total;
    }

    private boolean inBounds(int r, int c, int m, int n) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}