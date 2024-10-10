class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int min = Integer.MAX_VALUE;
        int minIdx = nums.length;
        int width = 0;

        for (int i = nums.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                width = Math.max(i - stack.pop(), width);
            }
        }
        return width;
    }
}