class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] dp = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (search(board, word, 0, dp, new boolean[board.length][board[0].length], r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int index, boolean[][] dp, boolean[][] vis, int r, int c) {
        if (index == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if (vis[r][c]) return false;
        if (word.charAt(index) != board[r][c]) return false;
        vis[r][c] = true;
        if (dp[r][c]) return true;
        dp[r][c] = search(board, word, index + 1, dp, vis, r + 1, c)
            || search(board, word, index + 1, dp, vis, r - 1, c)
            || search(board, word, index + 1, dp, vis, r, c + 1)
            || search(board, word, index + 1, dp, vis, r, c - 1);
        vis[r][c] = false;
        return dp[r][c];
    }
}