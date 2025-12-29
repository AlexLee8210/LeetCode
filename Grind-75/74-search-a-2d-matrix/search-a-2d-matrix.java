class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / n;
            int col = mid % n;
            if (row >= m || col >= n) return false;
            if (matrix[row][col] < target) {
                l = mid + 1;
            } else if (matrix[row][col] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}