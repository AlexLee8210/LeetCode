class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int l = 0, r = height.length - 1;
        int total = 0;

        while (l < r) {
            leftMax = Math.max(height[l], leftMax);
            rightMax = Math.max(height[r], rightMax);
            if (height[l] < height[r]) {
                total += Math.min(leftMax, rightMax) - height[l];
                ++l;
            } else {
                total += Math.min(leftMax, rightMax) - height[r];
                --r;
            }
        }

        return total;
    }
}