class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < board.length; ++r) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for (int c = 0; c < board[0].length; ++c) {
                if (board[r][c] != '.') {
                    if (row.contains(board[r][c])) return false;
                    row.add(board[r][c]);
                }

                if (board[c][r] != '.') {
                    if (col.contains(board[c][r])) return false;
                    col.add(board[c][r]);
                }

                // 3,5 -> 3,2
                // 4,1 -> 3,4
                // r: r / 3 + c / 3
                // c: c % 3 + r % 3 * 3
                int boxr = (r / 3) * 3 + c / 3;
                int boxc = c % 3 + (r % 3) * 3;
                // System.out.println(r + "," + c + " -> " + boxr + "," + boxc);
                if (board[boxr][boxc] != '.') {
                    if (box.contains(board[boxr][boxc])) return false;
                    box.add(board[boxr][boxc]);
                }
            }
        }
        return true;
    }
}