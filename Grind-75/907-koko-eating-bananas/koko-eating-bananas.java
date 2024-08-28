class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = maxPile(piles);
        int res = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canFinish(piles, h, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    private int maxPile(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int sum = 0;
        for (int n : piles) {
            sum += Math.ceil((double)n / k);
            if (sum > h) return false;
        }
        return true;
    }
}