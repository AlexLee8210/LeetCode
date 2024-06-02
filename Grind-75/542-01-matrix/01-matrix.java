class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int INF = mat.length + mat[0].length;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) continue;
                int top = INF, left = INF;
                if (r > 0) top = mat[r - 1][c];
                if (c > 0) left = mat[r][c - 1];
                mat[r][c] = Math.min(top, left) + 1;
            }
        }
        for (int r = mat.length - 1; r >= 0; r--) {
            for (int c = mat[0].length - 1; c >= 0; c--) {
                if (mat[r][c] == 0) continue;
                int bottom = INF, right = INF;
                if (r < mat.length - 1) bottom = mat[r + 1][c];
                if (c < mat[0].length - 1) right = mat[r][c + 1];
                mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }
}