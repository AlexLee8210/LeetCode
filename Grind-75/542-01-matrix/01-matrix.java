class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int INF = mat.length + mat[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) {
                    q.add(new Pair<>(r, c));
                } else {
                    mat[r][c] = INF;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair<Integer, Integer> pos = q.poll();
            int r = pos.getKey(), c = pos.getValue();
            int comp = mat[r][c] + 1;

            if (r > 0) {
                if (mat[r - 1][c] > comp) {
                    mat[r - 1][c] = comp;
                    q.add(new Pair<>(r - 1, c));
                }
            }
            if (r < mat.length - 1) {
                if (mat[r + 1][c] > comp) {
                    mat[r + 1][c] = comp;
                    q.add(new Pair<>(r + 1, c));
                }
            }
            if (c > 0) {
                if (mat[r][c - 1] > comp) {
                    mat[r][c - 1] = comp;
                    q.add(new Pair<>(r, c - 1));
                }
            }
            if (c < mat[0].length - 1) {
                if (mat[r][c + 1] > comp) {
                    mat[r][c + 1] = comp;
                    q.add(new Pair<>(r, c + 1));
                }
            }
        }
        return mat;
    }
}