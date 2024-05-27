class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);
        return climbStairsHelper(n, memo);
    }

    private int climbStairsHelper(int n, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int ways = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        memo.put(n, ways);
        return ways;
    }
}