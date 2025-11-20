class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int topSwaps = minSwaps(tops, bottoms, tops[0]);
        if (topSwaps != -1) return topSwaps;
        return minSwaps(tops, bottoms, bottoms[0]);
    }

    private int minSwaps(int[] tops, int[] bottoms, int tgt) {
        int top = 0;
        int bot = 0;
        for (int i = 0; i < tops.length; ++i) {
            if (tops[i] != tgt && bottoms[i] != tgt) return -1;
            if (tops[i] != tgt) ++top;
            if (bottoms[i] != tgt) ++bot;
        }
        return Math.min(top, bot);
    }
}