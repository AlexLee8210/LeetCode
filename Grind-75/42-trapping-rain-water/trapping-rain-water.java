class Solution {
    public int trap(int[] height) {
        int total = 0;
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        while (l < r) {
            if (height[l] <= height[r]) {
                ++l;
                maxL = Math.max(maxL, height[l]);
                total += Math.max(Math.min(maxL, maxR) - height[l], 0);
            } else {
                --r;
                maxR = Math.max(maxR, height[r]);
                total += Math.max(Math.min(maxL, maxR) - height[r], 0);
            }
        }
        return total;
    }
}