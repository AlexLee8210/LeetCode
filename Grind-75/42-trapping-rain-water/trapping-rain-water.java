class Solution {
    public int trap(int[] height) {
        int total = 0;
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        while (l < r) {
            if (maxL < maxR) {
                l++;
                maxL = Math.max(maxL, height[l]);
                total += Math.max(0, Math.min(maxL, maxR) - height[l]);
            } else {
                r--;
                maxR = Math.max(maxR, height[r]);
                total += Math.max(0, Math.min(maxL, maxR) - height[r]);
            }
        }
        return total;
    }
}