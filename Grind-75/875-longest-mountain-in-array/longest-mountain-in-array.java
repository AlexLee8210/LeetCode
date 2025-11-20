class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;
        int mtnState = 0; // 0: nothing, 1: up, 2: down
        int start = -1;
        int maxLen = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (mtnState == 0) {
                if (arr[i] > arr[i - 1]) {
                    mtnState = 1;
                    start = i - 1;
                }
            } else if (mtnState == 1) {
                if (arr[i] < arr[i - 1]) {
                    mtnState = 2;
                } else if (arr[i] == arr[i - 1]) {
                    start = -1;
                    mtnState = 0;
                }
            } else if (mtnState == 2) {
                if (arr[i] >= arr[i - 1]) {
                    maxLen = Math.max(maxLen, i - start);
                    mtnState = 0;
                    if (arr[i] > arr[i - 1]) {
                        start = i - 1;
                        mtnState = 1;
                    }
                }
            }
        }

        if (mtnState == 2) {
            maxLen = Math.max(maxLen, arr.length - start);
        }

        return maxLen;
    }
}