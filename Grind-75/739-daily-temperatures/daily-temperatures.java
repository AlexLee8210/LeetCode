class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{temperatures[0], 0});
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int idx = stack.pop()[1];
                ans[idx] = i - idx;
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return ans;
    }
}