class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int maxLen = 0;
        int i = 1;
        while (i < n) {
            int inc = 0, dec = 0;
            while (i < n && arr[i - 1] < arr[i]) {
                ++i;
                ++inc;
            }
            while (i < n && arr[i - 1] > arr[i]) {
                ++i;
                ++dec;
            }
            if (inc > 0 && dec > 0) {
                maxLen = Math.max(maxLen, inc + dec + 1);
            }

            while (i < n && arr[i - 1] == arr[i]) ++i;
        }

        return maxLen;
    }
}