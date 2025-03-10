class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];
        int total = 0;

        while (l < r) {
            if (maxLeft <= maxRight) {
                maxLeft = Math.max(height[++l], maxLeft);
                total += maxLeft - height[l];
            } else {
                maxRight = Math.max(height[--r], maxRight);
                total += maxRight - height[r];
            }
        }

        return total;
    }
}