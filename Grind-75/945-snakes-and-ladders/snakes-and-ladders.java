class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n];

        Deque<Integer> q = new LinkedList<>();
        q.addLast(1);
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int num = q.poll();
                if (num == n * n) return dist;

                if (vis[num]) continue;
                vis[num] = true;

                int[] pos = numToPos(num, n);
                int row = pos[0];
                int col = pos[1];

                for (int next = num + 1; next <= Math.min(n * n, num + 6); ++next) {
                    int[] nextPos = numToPos(next, n);
                    int nextRow = nextPos[0];
                    int nextCol = nextPos[1];
                    if (board[nextRow][nextCol] == -1) q.offer(next);
                    else q.offer(board[nextRow][nextCol]);
                }
            }
            ++dist;
        }

        return -1;
    }

    private int[] numToPos(int num, int n) {
        int row = (n - 1) - (num - 1) / n;
        int col = (num - 1) % n;

        // if n is even, even rows backwards
        // if n is odd, odd rows backwards
        if (n % 2 == row % 2) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}