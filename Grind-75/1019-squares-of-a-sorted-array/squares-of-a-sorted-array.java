class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        // System.out.println(r);
        // return nums;
        // int 
        int pos = r + 1;
        int[] res = new int[nums.length];
        int index = 0;
        while (pos < nums.length || r >= 0) {
            int next = Integer.MAX_VALUE;
            if (pos < nums.length) {
                next = nums[pos];
            }
            if (r >= 0) {
                next = Math.min(next, Math.abs(nums[r]));
            }
            if (r >= 0 && next == Math.abs(nums[r])) {
                r--;
            } else {
                pos++;
            }
            res[index++] = (int)Math.pow(next, 2);
        }
        return res;
    }
}