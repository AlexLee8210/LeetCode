class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean valid = true;
        HashSet<Character> row, col, grid;
        for (int r = 0; r < board.length; r++) {
            row = new HashSet<>();
            col = new HashSet<>();
            grid = new HashSet<>();
            for (int c = 0; c < board.length; c++) {
                if (board[r][c] != '.' && !row.add(board[r][c])) {
                    return false;
                }
                if (board[c][r] != '.' && !col.add(board[c][r])) {
                    return false;
                }
                int rIndex = (r / 3) * 3 + c / 3;
                int cIndex = (r % 3) * 3 + c % 3;
                if (board[rIndex][cIndex] != '.' && !grid.add(board[rIndex][cIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
}