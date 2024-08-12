class Solution {
    private int[][] dirs = new int[][]{{-1, -2}, {-2, -1}};
    public int minKnightMoves(int x, int y) {
        HashMap<String, Integer> memo = new HashMap<>();
        return dfs(Math.abs(x), Math.abs(y), memo);
    }

    private int dfs(int x, int y, HashMap<String, Integer> memo) {
        String key = x + "," + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (x == 0 && y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        }
        int res = Math.min(
            dfs(Math.abs(x - 1), Math.abs(y - 2), memo),
            dfs(Math.abs(x - 2), Math.abs(y - 1), memo)
        ) + 1;
        memo.put(key, res);
        return res;
    }
}