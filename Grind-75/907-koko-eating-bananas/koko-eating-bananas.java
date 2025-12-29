class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }

        int l = 0, r = max, k = max;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canFinish(piles, m, h)) {
                k = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return k;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int i = 0;
        while (i < piles.length && h > 0) {
            int numHours = (int) Math.ceil((double) piles[i] / k);
            h -= numHours;
            ++i;
        }
        return h >= 0 && i == piles.length;
    }
}