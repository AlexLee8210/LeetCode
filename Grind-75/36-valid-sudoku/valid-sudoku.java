class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean valid = true;
        HashSet<Character> row, col;
        for (int r = 0; r < board.length; r++) {
            row = new HashSet<>();
            col = new HashSet<>();
            for (int c = 0; c < board.length; c++) {
                if (Character.isDigit(board[r][c])) {
                    if (row.contains(board[r][c])) return false;
                    row.add(board[r][c]);
                }
                if (Character.isDigit(board[c][r])) {
                    if (col.contains(board[c][r])) return false;
                    col.add(board[c][r]);
                }
            }
        }
        for (int r = 0; r < board.length; r += 3) {
            for (int c = 0; c < board[0].length; c += 3) {
                if (!valid9(board, r, c)) return false;
            }
        }
        return true;
    }

    private boolean valid9(char[][] board, int row, int col) {
        HashSet<Character> seen = new HashSet<>();
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                if (!Character.isDigit(board[r][c])) continue;
                if (seen.contains(board[r][c])) return false;
                seen.add(board[r][c]);
            }
        }
        return true;
    }
}