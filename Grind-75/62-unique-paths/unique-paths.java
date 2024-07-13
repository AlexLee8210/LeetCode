class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int c = 0; c < n; c++) {
            paths[0][c] = 1;
        }
        for (int r = 1; r < m; r++) {
            paths[r][0] = 1;
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                paths[r][c] = paths[r - 1][c] + paths[r][c - 1];
            }
        }
        return paths[m - 1][n - 1];
    }
}