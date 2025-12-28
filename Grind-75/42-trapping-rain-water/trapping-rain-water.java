class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = l, maxR = r;
        int total = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                total += Math.max(0, Math.min(height[maxL], height[maxR]) - height[l]);
                ++l;
                if (height[l] > height[maxL]) {
                    maxL = l;
                }
            } else {
                total += Math.max(0, Math.min(height[maxL], height[maxR]) - height[r]);
                --r;
                if (height[r] > height[maxR]) {
                    maxR = r;
                }
            }
        }

        return total;
    }
}