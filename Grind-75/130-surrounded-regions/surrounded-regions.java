class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        List<int[]> border = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') {
                capture(board, i, 0, 'T');
                border.add(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                capture(board, i, n - 1, 'T');
                border.add(new int[]{i, n - 1});
            }
        }
        for (int i = 0; i < n; ++i) {
            if (board[0][i] == 'O') {
                capture(board, 0, i, 'T');
                border.add(new int[]{0, i});
            }
            if (board[m - 1][i] == 'O') {
                capture(board, m - 1, i, 'T');
                border.add(new int[]{m - 1, i});
            }
        }

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < board[0].length; ++c) {
                if (board[r][c] == 'O') capture(board, r, c, 'X');
            }
        }

        for (int[] pos : border){
            capture(board, pos[0], pos[1], 'O');
        }
    }

    private void capture(char[][] board, int r, int c, char f) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        if (board[r][c] == 'X' || board[r][c] == f) return;

        board[r][c] = f;
        capture(board, r, c - 1, f);
        capture(board, r - 1, c, f);
        capture(board, r, c + 1, f);
        capture(board, r + 1, c, f);
    }
}