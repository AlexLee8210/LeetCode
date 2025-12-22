class Solution {
    public int minOperations(int[] nums) {
        int ops = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int n : nums) {
            while (!stack.isEmpty() && stack.peek() > n) {
                stack.pop();
            }
            if (n == 0) continue;
            if (stack.isEmpty() || stack.peek() != n) {
                ++ops;
                stack.push(n);
            }
        }

        return ops;
    }
}