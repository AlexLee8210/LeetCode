class Solution {
    private class Node {
        int row, col, height;

        public Node(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    private boolean inBounds(int r, int c, int m, int n) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) {
            return 0;
        }
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = heightMap.length;
        int n = heightMap[0].length;

        int total = 0;

        boolean[][] vis = new boolean[m][n];
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> {
            return a.height - b.height;
        });

        for (int c = 0; c < n; ++c) {
            vis[0][c] = true;
            vis[m - 1][c] = true;
            pq.offer(new Node(0, c, heightMap[0][c]));
            pq.offer(new Node(m - 1, c, heightMap[m - 1][c]));
        }

        for (int r = 0; r < m; ++r) {
            vis[r][0] = true;
            vis[r][n - 1] = true;
            pq.offer(new Node(r, 0, heightMap[r][0]));
            pq.offer(new Node(r, n - 1, heightMap[r][n - 1]));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (int[] dir : dirs) {
                int newRow = cur.row + dir[0];
                int newCol = cur.col + dir[1];

                if (!inBounds(newRow, newCol, m, n) || vis[newRow][newCol]) continue;

                vis[newRow][newCol] = true;
                pq.offer(new Node(newRow, newCol, Math.max(cur.height, heightMap[newRow][newCol])));

                total += Math.max(0, cur.height - heightMap[newRow][newCol]);
            }
        }

        return total;
    }
}