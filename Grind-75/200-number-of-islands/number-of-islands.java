class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '0') continue;
                traverse(grid, r, c);
                num++;
            }
        }
        return num;
    }

    private void traverse(char[][] grid, int row, int col) {
        if (!isValid(grid.length, grid[0].length, row, col)) return;
        if (grid[row][col] == '0') return;
        grid[row][col] = '0';
        traverse(grid, row - 1, col);
        traverse(grid, row + 1, col);
        traverse(grid, row, col - 1);
        traverse(grid, row, col + 1);
        return;
    }

    private boolean isValid(int m, int n, int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}