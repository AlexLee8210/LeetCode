class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int total = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                ++l;
                leftMax = Math.max(height[l], leftMax);
                total += leftMax - height[l];
            } else {
                --r;
                rightMax = Math.max(height[r], rightMax);
                total += rightMax - height[r];
            }
        }

        return total;
    }
}