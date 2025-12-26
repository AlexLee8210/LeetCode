class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // [temp, idx]
        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int j = stack.pop()[1];
                res[j] = i - j;
            }

            stack.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}