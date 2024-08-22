class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[0] > heights[i]) {
                int[] top = stack.pop();
                max = Math.max((i - top[1]) * top[0], max);
                start = top[1];
            }
            stack.push(new int[]{heights[i], start});
        }
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            max = Math.max((heights.length - top[1]) * top[0], max);
        }
        return max;
    }
}