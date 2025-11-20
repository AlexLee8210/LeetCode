class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] tfreq = new int[7];
        int[] bfreq = new int[7];
        int[] doubles = new int[7];

        for (int i = 0; i < n; ++i) {
            if (tops[i] == bottoms[i]) {
                ++doubles[tops[i]];
            }
            ++tfreq[tops[i]];
            ++bfreq[bottoms[i]];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; ++i) {
            if (n <= bfreq[i] + tfreq[i] - doubles[i]) {
                min = Math.min(min, Math.min(n - bfreq[i], n - tfreq[i]));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}