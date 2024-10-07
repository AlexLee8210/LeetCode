class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[r].length; ++c) {
                if (helper(board, word.toCharArray(), 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, char[] word, int index, int row, int col) {
        if (index == word.length) return true;

        // if (vis[row][col]) return false;
        if (board[row][col] != word[index]) return false;

        // vis[row][col] = true;
        board[row][col] = '*';

        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];

            if (r < 0 || r >= board.length || c < 0 || c >= board[r].length) continue;

            if (helper(board, word, index + 1, r, c)) {
                return true;
            }
        }
        // vis[row][col] = false;
        board[row][col] = word[index];
        return index == word.length - 1;
    }
}