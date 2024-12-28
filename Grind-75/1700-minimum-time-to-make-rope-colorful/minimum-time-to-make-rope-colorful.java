class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        int n = neededTime.length;
        int max = 0;
        int total = 0;

        int res = 0;

        for (int i = 1; i < n; ++i) {
            if (arr[i - 1] == arr[i]) {
                total += neededTime[i - 1];
                max = Math.max(max, neededTime[i - 1]);
            } else if (total != 0) {
                total += neededTime[i - 1];
                max = Math.max(max, neededTime[i - 1]);

                res += total - max;

                total = 0;
                max = 0;
            }
        }
        
        if (total != 0) {
            total += neededTime[n - 1];
            max = Math.max(max, neededTime[n - 1]);

            res += total - max;
        }

        return res;
    }
}