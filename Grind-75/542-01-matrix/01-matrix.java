class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (mat[r][c] == 0) continue;
                int left = c == 0 ? Integer.MAX_VALUE : mat[r][c - 1];
                int up = r == 0 ? Integer.MAX_VALUE : mat[r - 1][c];
                int dist = Math.min(left, up);
                if (dist != Integer.MAX_VALUE) {
                    ++dist;
                }
                mat[r][c] = dist;
            }
        }
        for (int r = m - 1; r >= 0; --r) {
            for (int c = n - 1; c >= 0; --c) {
                if (mat[r][c] == 0) continue;
                int right = c == n - 1 ? Integer.MAX_VALUE : mat[r][c + 1];
                int down = r == m - 1 ? Integer.MAX_VALUE : mat[r + 1][c];
                int dist = Math.min(right, down);
                if (dist != Integer.MAX_VALUE) {
                    ++dist;
                }
                mat[r][c] = Math.min(mat[r][c], dist);
            }
        }
        return mat;
    }
}