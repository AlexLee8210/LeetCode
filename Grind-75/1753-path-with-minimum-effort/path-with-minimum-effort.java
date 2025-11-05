class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int[][] dist = new int[heights.length][heights[0].length];
        for (int r = 0; r < heights.length; ++r) {
            Arrays.fill(dist[r], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            int r = item[0];
            int c = item[1];
            int effort = item[2];

            if (dist[r][c] < effort) {
                continue;
            }
            
            if (r == heights.length - 1 && c == heights[0].length - 1) {
                return effort;
            }

            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (!inBounds(newR, newC, heights.length, heights[0].length)) {
                    continue;
                }

                int newEffort = Math.max(effort, Math.abs(heights[newR][newC] - heights[r][c]));

                if (newEffort < dist[newR][newC]) {
                    dist[newR][newC] = newEffort;
                    pq.offer(new int[]{newR, newC, newEffort});
                }
            }
        }

        return -1;
    }

    private boolean inBounds(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}