class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        // Arrays.sort(coins);
        int minIdx = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[minIdx] > coins[i]) {
                minIdx = i;
            }
        }
        int tmp = coins[0];
        coins[0] = coins[minIdx];
        coins[minIdx] = tmp;
        if (coins[0] > amount) return -1;
        int[] amounts = new int[amount + 1];
        for (int i = 1; i < coins[0]; i++) {
            amounts[i] = -1;
        }
        for (int i = coins[0]; i < amounts.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int val : coins) {
                int target = i - val;
                if (target < 0 || amounts[target] == -1) {
                    continue;
                }
                min = Math.min(amounts[target] + 1, min);
            }
            amounts[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return amounts[amount];
    }
}