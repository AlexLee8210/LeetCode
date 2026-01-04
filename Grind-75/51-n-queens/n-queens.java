class Solution {
    private int[][] dirs = new int[][]{
        {-1, 0}, {1, 0},
        {0, -1}, {0, 1},
        {-1, -1}, {1, 1},
        {-1, 1}, {1, -1}
    };

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(board[i], '.');
        }
        helper(n, 0, board, res, new boolean[2 * n], new boolean[2 * n], new boolean[3 * n]);
        return res;
    }

    private void helper(int n, int idx, char[][] board, List<List<String>> res, boolean[] vcol, boolean[] vposdiag, boolean[] vnegdiag) {
        if (idx == n) {
            System.out.println(res);
            List<String> cur = new ArrayList<>();
            for (char[] row : board) {
                cur.add(new String(row));
            }
            res.add(cur);
            return;
        }

        int r = idx;
        for (int c = 0; c < n; ++c) {
            if (board[r][c] != '.') continue;

            boolean valid = !(vcol[c] || vposdiag[r + c] || vnegdiag[r - c + n]);
            // for (int[] dir : dirs) {
            //     if (!canPlace(r, c, dir[0], dir[1], board)) {
            //         valid = false;
            //         break;
            //     }
            // }


            if (!valid) continue;
            
            board[r][c] = 'Q';
            vcol[c] = true;
            vposdiag[r + c] = true;
            vnegdiag[r - c + n] = true;
            helper(n, idx + 1, board, res, vcol, vposdiag, vnegdiag);
            vcol[c] = false;
            vposdiag[r + c] = false;
            vnegdiag[r - c + n] = false;
            board[r][c] = '.';
        }
    }

    // private boolean canPlace(int r, int c, int dr, int dc, char[][] board) {
    //     int n = board.length;
    //     while (r >= 0 && r < n && c >= 0 && c < n) {
    //         if (board[r][c] == 'Q') return false;
    //         r += dr;
    //         c += dc;
    //     }
    //     return true;
    // }
}