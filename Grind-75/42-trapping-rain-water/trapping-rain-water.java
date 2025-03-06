class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];
        int total = 0;

        while (l < r) {
            if (maxLeft <= maxRight) {
                ++l;
                maxLeft = Math.max(maxLeft, height[l]);
                total += maxLeft - height[l];
            } else {
                --r;
                maxRight = Math.max(maxRight, height[r]);
                total += maxRight - height[r];
            }
        }

        return total;
    }
}