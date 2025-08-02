class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        int MAX = m + n;

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (mat[r][c] == 0) continue;
                if (r == 0 && c == 0) dist[r][c] = MAX;
                else if (r == 0) dist[r][c] = (dist[r][c - 1] == MAX) ? MAX : dist[r][c - 1] + 1;
                else if (c == 0) dist[r][c] = (dist[r - 1][c] == MAX) ? MAX : dist[r - 1][c] + 1;
                else dist[r][c] = Math.min(dist[r - 1][c], dist[r][c - 1]) + 1;
            }
        }

        for (int r = m - 1; r >= 0; --r) {
            for (int c = n - 1; c >= 0; --c) {
                if (mat[r][c] == 0) continue;
                if (r == m - 1 && c == n - 1) continue;
                if (r == m - 1) dist[r][c] = Math.min(dist[r][c], dist[r][c + 1] + 1);
                else if (c == n - 1) dist[r][c] = Math.min(dist[r][c], dist[r + 1][c] + 1);
                else dist[r][c] = Math.min(dist[r][c], Math.min(dist[r + 1][c], dist[r][c + 1]) + 1);
            }
        }

        return dist;
    }
}