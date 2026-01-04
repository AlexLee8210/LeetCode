class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[0].length; ++c) {
                if (dfs(board, word, 0, r, c, new boolean[board.length][board[0].length])) return true;
            }
        }
        return false;
    }

    private boolean inbounds(int r, int c, int m, int n) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }

    private boolean dfs(char[][] board, String word, int idx, int r, int c, boolean[][] vis) {
        if (idx == word.length()) return true;
        if (word.charAt(idx) != board[r][c]) return false;

        vis[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (!inbounds(nr, nc, board.length, board[0].length)) continue;
            if (vis[nr][nc]) continue;
            if (dfs(board, word, idx + 1, nr, nc, vis)) return true;
        }

        vis[r][c] = false;
        return idx == word.length() - 1;
    }
}