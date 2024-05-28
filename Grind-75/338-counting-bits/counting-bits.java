class Solution {
    public int[] countBits(int n) {
        int[] bin = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bin[i] = bin[i / 2] + (i % 2);
        }
        return bin;
    }
}