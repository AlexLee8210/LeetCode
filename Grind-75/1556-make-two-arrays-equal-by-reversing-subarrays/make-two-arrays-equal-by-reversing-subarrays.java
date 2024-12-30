class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] freq = new int[1001];
        for (int t : target) {
            ++freq[t];
        }
        for (int a : arr) {
            if (--freq[a] < 0) return false;
        }
        return true;
    }
}