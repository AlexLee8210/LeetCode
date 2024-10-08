class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            if (area > max) {
                max = area;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}