class Solution {
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int n : data) {
            ones += n;
        }

        int zeroes = 0;
        for (int i = 0; i < ones; ++i) {
            zeroes += (data[i] == 0 ? 1 : 0);
        }

        int min = zeroes;
        for (int i = ones; i < data.length; ++i) {
            if (data[i - ones] == 0) --zeroes;
            if (data[i] == 0) ++zeroes;
            min = Math.min(min, zeroes);
        }

        return min;
    }
}