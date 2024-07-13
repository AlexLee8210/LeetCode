class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = 0;
        int ms = 0, ns = 0;
        while (ms < m && ns < n) {
            while (col < n) {
                res.add(matrix[row][col++]);
            }
            col--;
            ms++;
            row++;
            if (ms >= m) break;
            while (row < m) {
                res.add(matrix[row++][col]);
            }
            row--;
            n--;
            col--;
            if (ns >= n) break;
            while (col >= ns) {
                res.add(matrix[row][col--]);
            }
            col++;
            m--;
            row--;
            if (ms >= m) break;
            while (row >= ms) {
                res.add(matrix[row--][col]);
            }
            row++;
            ns++;
            col++;
            // System.out.println(ms + ", " + m);
        }
        return res;

        // c+, r+, c-, r-
        // r c
        // 0 0
        // 0 1
        // 0 2
        // 1 2
        // 2 2
        // 2 1
        // 2 0
        // 1 0
        // 1 1
    }
}