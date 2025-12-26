class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Set<Character> h = new HashSet<>();
        Set<Character>[] boxes = new Set[9];
        for (int i = 0; i < 9; ++i) {
            boxes[i] = new HashSet<>();
        }
        for (int r = 0; r < board.length; ++r) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            for (int c = 0; c < board[0].length; ++c) {
                if (board[r][c] != '.') {
                    if (row.contains(board[r][c])) return false;
                    row.add(board[r][c]);

                    int box = cellToBox(r, c);
                    if (boxes[box].contains(board[r][c])) return false;
                    boxes[box].add(board[r][c]);
                }

                if (board[c][r] != '.') {
                    if (col.contains(board[c][r])) return false;
                    col.add(board[c][r]);
                }
            }
        }
        return true;
    }

    private int cellToBox(int r, int c) {
        // 0,0 -> 0
        // 0,3 -> 1
        // 2,3 -> 1
        // 5,5 -> 4
        // r/3 * 3 + c/3
        return (r / 3) * 3 + c / 3;
    }
}